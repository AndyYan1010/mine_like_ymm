package com.bt.smart.truck_broker.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bt.smart.truck_broker.MyApplication;
import com.bt.smart.truck_broker.NetConfig;
import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.activity.samedayAct.OrderDetailActivity;
import com.bt.smart.truck_broker.adapter.RecyOrderAdapter;
import com.bt.smart.truck_broker.messageInfo.AllOrderListInfo;
import com.bt.smart.truck_broker.messageInfo.LinesOrderInfo;
import com.bt.smart.truck_broker.utils.HttpOkhUtils;
import com.bt.smart.truck_broker.utils.ProgressDialogUtil;
import com.bt.smart.truck_broker.utils.RequestParamsFM;
import com.bt.smart.truck_broker.utils.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/10 13:45
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class OrderListByLineFragment extends Fragment implements View.OnClickListener {
    private View                            mRootView;
    private ImageView                       img_back;
    private TextView                        tv_title;
    private TextView                        tv_lineName;
    private RecyclerView                    recy_order;
    private List<AllOrderListInfo.DataBean> mData;
    private RecyOrderAdapter                orderAdapter;
    private int REQUEST_FOR_TAKE_ORDER = 12087;//接单返回
    private int RESULT_TAKE_ORDER      = 12088;//接单成功响应值
    private String lineID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.frame_line_order_list, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        img_back = mRootView.findViewById(R.id.img_back);
        tv_title = mRootView.findViewById(R.id.tv_title);
        tv_lineName = mRootView.findViewById(R.id.tv_lineName);
        recy_order = mRootView.findViewById(R.id.recy_order);
    }

    private void initData() {
        img_back.setVisibility(View.VISIBLE);
        tv_title.setText("货源列表");
        lineID = getActivity().getIntent().getStringExtra("lineID");
        //初始化货源列表数据
        initOrderList();
        //获取线路货源
        getOrdersByLine();

        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                getActivity().finish();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_FOR_TAKE_ORDER == requestCode && RESULT_TAKE_ORDER == resultCode) {
            //刷新界面
            //获取线路货源
            getOrdersByLine();
        }
    }

    private void getOrdersByLine() {
        RequestParamsFM headParam = new RequestParamsFM();
        headParam.put("X-AUTH-TOKEN", MyApplication.userToken);
        HttpOkhUtils.getInstance().doGetWithOnlyHeader(NetConfig.DRIVERJOURNEYCONTROLLER + "/getOrder/" + lineID, headParam, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(getContext(), "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                if (code != 200) {
                    ToastUtils.showToast(getContext(), "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                LinesOrderInfo linesOrderInfo = gson.fromJson(resbody, LinesOrderInfo.class);
                ToastUtils.showToast(getContext(), linesOrderInfo.getMessage());
                if (linesOrderInfo.isOk()) {
                    mData.clear();
                    for (LinesOrderInfo.DataBean bean : linesOrderInfo.getData()) {
                        AllOrderListInfo.DataBean bean1 = new AllOrderListInfo.DataBean();
                        bean1.setFhAddress(bean.getFh_address());
                        bean1.setShAddress(bean.getSh_address());
                        bean1.setId(bean.getId());
                        bean1.setGoodsName(bean.getGoods_name());
                        bean1.setZhTime(bean.getZh_time());
                        bean1.setFhName(bean.getFh_name());
                        bean1.setFhTelephone(bean.getFh_telephone());
                        mData.add(bean1);
                    }
                    orderAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void initOrderList() {
        mData = new ArrayList();
        recy_order.setLayoutManager(new LinearLayoutManager(getContext()));
        orderAdapter = new RecyOrderAdapter(R.layout.adpter_sameday_order, getContext(), mData);
        recy_order.setAdapter(orderAdapter);
        orderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
//                    case R.id.linear_item:
//
//                        break;
//                    case R.id.img_call:
//                        ShowCallUtil.showCallDialog(getContext(), mData.get(position).getFhTelephone());
//                        break;
                }
            }
        });
        orderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(getContext(), OrderDetailActivity.class);
                intent.putExtra("orderID", mData.get(position).getId());
                startActivityForResult(intent, REQUEST_FOR_TAKE_ORDER);
                startActivity(intent);
            }
        });
    }
}
