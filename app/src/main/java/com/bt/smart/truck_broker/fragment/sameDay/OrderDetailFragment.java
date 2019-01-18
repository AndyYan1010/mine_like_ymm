package com.bt.smart.truck_broker.fragment.sameDay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bt.smart.truck_broker.MyApplication;
import com.bt.smart.truck_broker.NetConfig;
import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.messageInfo.OrderDetailInfo;
import com.bt.smart.truck_broker.messageInfo.TakeOrderResultInfo;
import com.bt.smart.truck_broker.utils.HttpOkhUtils;
import com.bt.smart.truck_broker.utils.MyFragmentManagerUtil;
import com.bt.smart.truck_broker.utils.ProgressDialogUtil;
import com.bt.smart.truck_broker.utils.RequestParamsFM;
import com.bt.smart.truck_broker.utils.ShowCallUtil;
import com.bt.smart.truck_broker.utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/8 21:35
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class OrderDetailFragment extends Fragment implements View.OnClickListener {
    private View            mRootView;
    private ImageView       img_back;
    private ImageView       img_empty;
    private TextView        tv_title;
    private String          orderID;
    private TextView        tv_place;
    private TextView        tv_goodsname;
    private TextView        tv_carType;
    private TextView        tv_name;
    private TextView        tv_fhPlace;
    private TextView        tv_phone;
    private TextView        tv_cont;//联系货主
    private TextView        tv_take;//接单
    private OrderDetailInfo orderDetailInfo;//订单详情
    private int RESULT_TAKE_ORDER = 12088;//接单成功响应值

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.frame_order_detail, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        img_back = mRootView.findViewById(R.id.img_back);
        img_empty = mRootView.findViewById(R.id.img_empty);
        tv_title = mRootView.findViewById(R.id.tv_title);
        tv_place = mRootView.findViewById(R.id.tv_place);
        tv_goodsname = mRootView.findViewById(R.id.tv_goodsname);
        tv_carType = mRootView.findViewById(R.id.tv_carType);
        tv_name = mRootView.findViewById(R.id.tv_name);
        tv_fhPlace = mRootView.findViewById(R.id.tv_fhPlace);
        tv_phone = mRootView.findViewById(R.id.tv_phone);
        tv_cont = mRootView.findViewById(R.id.tv_cont);
        tv_take = mRootView.findViewById(R.id.tv_take);
    }

    private void initData() {
        tv_title.setText("货源详情");
        img_back.setVisibility(View.VISIBLE);
        orderID = getActivity().getIntent().getStringExtra("orderID");
        //获取货源详情
        getOrderDetail();
        img_back.setOnClickListener(this);
        tv_cont.setOnClickListener(this);
        tv_take.setOnClickListener(this);
        img_empty.setOnClickListener(this);
        String touchKind = getActivity().getIntent().getStringExtra("touchKind");
        if (null != touchKind && "accepted".equals(touchKind)) {
            tv_take.setVisibility(View.GONE);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_empty:
                //获取货源详情
                getOrderDetail();
                break;
            case R.id.img_back:
                MyFragmentManagerUtil.closeFragmentOnAct(this);
                break;
            case R.id.tv_cont://联系货主
                ShowCallUtil.showCallDialog(getContext(), orderDetailInfo.getData().getFh_telephone());
                break;
            case R.id.tv_take:
                //接单
                takeOrder();
                break;
        }
    }

    private void takeOrder() {
        RequestParamsFM headParams = new RequestParamsFM();
        headParams.put("X-AUTH-TOKEN", MyApplication.userToken);
        RequestParamsFM params = new RequestParamsFM();
        params.put("driverId", MyApplication.userID);
        params.put("id", MyApplication.userID);
        params.put("orderId", orderDetailInfo.getData().getId());
        params.put("orderStatus", "0");
        params.setUseJsonStreamer(true);
        HttpOkhUtils.getInstance().doPostWithHeader(NetConfig.DRIVERORDERCONTROLLER, headParams, params, new HttpOkhUtils.HttpCallBack() {
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
                TakeOrderResultInfo takeOrderResultInfo = gson.fromJson(resbody, TakeOrderResultInfo.class);
                ToastUtils.showToast(getContext(), takeOrderResultInfo.getMessage());
                if (takeOrderResultInfo.isOk()) {
                    getActivity().setResult(RESULT_TAKE_ORDER);
                    getActivity().finish();
                }
            }
        });
    }

    private void getOrderDetail() {
        ProgressDialogUtil.startShow(getContext(), "正在获取详情...");
        RequestParamsFM headParams = new RequestParamsFM();
        headParams.put("X-AUTH-TOKEN", MyApplication.userToken);
        HttpOkhUtils.getInstance().doGetWithOnlyHeader(NetConfig.ALL_ORDER_DETAIL + "/" + orderID, headParams, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ProgressDialogUtil.hideDialog();
                ToastUtils.showToast(getContext(), "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                ProgressDialogUtil.hideDialog();
                img_empty.setVisibility(View.VISIBLE);
                if (code != 200) {
                    ToastUtils.showToast(getContext(), "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                orderDetailInfo = gson.fromJson(resbody, OrderDetailInfo.class);
                ToastUtils.showToast(getContext(), orderDetailInfo.getMessage());
                if (orderDetailInfo.isOk()) {
                    img_empty.setVisibility(View.GONE);
                    tv_place.setText(orderDetailInfo.getData().getOrigin() + "  →  " + orderDetailInfo.getData().getDestination());
                    tv_goodsname.setText(orderDetailInfo.getData().getGoods_name());
                    tv_carType.setText(orderDetailInfo.getData().getCar_type());
                    tv_name.setText(orderDetailInfo.getData().getFh_name());
                    tv_fhPlace.setText(orderDetailInfo.getData().getFh_address());
                    tv_phone.setText(orderDetailInfo.getData().getFh_telephone());
                }
            }
        });
    }
}
