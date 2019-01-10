package com.bt.smart.truck_broker.fragment.sameDay;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bt.smart.truck_broker.MyApplication;
import com.bt.smart.truck_broker.NetConfig;
import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.activity.samedayAct.OrderDetailActivity;
import com.bt.smart.truck_broker.adapter.RecyOrderAdapter;
import com.bt.smart.truck_broker.messageInfo.AllOrderListInfo;
import com.bt.smart.truck_broker.utils.HttpOkhUtils;
import com.bt.smart.truck_broker.utils.PopupOpenHelper;
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
 * @创建时间 2018/11/6 8:32
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SameDay_F extends Fragment implements View.OnClickListener {
    private View                            mRootView;
    private View                            view_b;//底部定位
    private TextView                        tv_title;
    private LinearLayout                    liner_top;
    private RelativeLayout                  rlt_title;
    private LinearLayout                    liner_term;
    private LinearLayout                    line_start;
    private LinearLayout                    line_end;
    private LinearLayout                    line_screen;
    private RecyclerView                    rec_order;
    private RecyOrderAdapter                orderAdapter;
    private List<AllOrderListInfo.DataBean> mData;
    private int REQUEST_FOR_TAKE_ORDER = 12087;//接单返回
    private int RESULT_TAKE_ORDER      = 12088;//接单成功响应值

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.sameday_f, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        tv_title = mRootView.findViewById(R.id.tv_title);
        view_b = mRootView.findViewById(R.id.view_b);
        liner_top = mRootView.findViewById(R.id.liner_top);
        rlt_title = mRootView.findViewById(R.id.rlt_title);
        liner_term = mRootView.findViewById(R.id.liner_term);
        line_start = mRootView.findViewById(R.id.line_start);
        line_end = mRootView.findViewById(R.id.line_end);
        line_screen = mRootView.findViewById(R.id.line_screen);
        rec_order = mRootView.findViewById(R.id.rec_order);
    }

    private void initData() {
        tv_title.setText("最新货源");
        line_start.setOnClickListener(this);
        line_end.setOnClickListener(this);
        line_screen.setOnClickListener(this);
        //初始化货源列表
        initOrderList();

        //设置rec_order滑动事件
        setRecyclerviewMoveEvent();
        //获取订单列表信息
        getOrderList(1, 10);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.line_start:
                //选择运输起点
                choiceStartPlace(line_start);
                break;
            case R.id.line_end:
                //选择运输终点
                choiceEndPlace();
                break;
            case R.id.line_screen:
                //筛选运输条件
                screenAllTerm();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_FOR_TAKE_ORDER == requestCode && RESULT_TAKE_ORDER == resultCode) {
            //刷新界面
            getOrderList(1, 10);
        }
    }

    private void initOrderList() {
        mData = new ArrayList();
        rec_order.setLayoutManager(new LinearLayoutManager(getContext()));
        orderAdapter = new RecyOrderAdapter(R.layout.adpter_sameday_order, getContext(), mData);
        rec_order.setAdapter(orderAdapter);
        orderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {

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

    private void getOrderList(int no, int size) {
        RequestParamsFM headParams = new RequestParamsFM();
        headParams.put("X-AUTH-TOKEN", MyApplication.userToken);
        String finalUrl = NetConfig.ALL_ORDER_LIST + "/" + no + "/" + size;
        HttpOkhUtils.getInstance().doGetWithOnlyHeader(finalUrl, headParams, new HttpOkhUtils.HttpCallBack() {
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
                AllOrderListInfo allOrderListInfo = gson.fromJson(resbody, AllOrderListInfo.class);
                ToastUtils.showToast(getContext(), allOrderListInfo.getMessage());
                if (allOrderListInfo.isOk()) {
                    mData.clear();
                    mData.addAll(allOrderListInfo.getData());
                    orderAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    int scDownY;
    int scMoveY;
    int rltTop;
    int rltBot;
    int rec_h;

    private void setRecyclerviewMoveEvent() {
        rec_order.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        scDownY = (int) motionEvent.getRawY();
                        rec_h = view_b.getTop();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        scMoveY = (int) motionEvent.getRawY();
                        rltTop = rltTop + (scMoveY - scDownY);
                        rltBot = rltTop + liner_top.getHeight();

                        if (rltTop >= 0) {
                            rltTop = 0;
                            rltBot = rltTop + liner_top.getHeight();
                        }
                        if (rltBot <= 0) {
                            rltBot = 0;
                            rltTop = rltBot - liner_top.getHeight();
                        }

                        liner_top.layout(0, rltTop, liner_top.getWidth(), rltBot);
                        rec_order.layout(0, rltTop + liner_top.getHeight(), rec_order.getWidth(), rec_h);

                        scDownY = (int) motionEvent.getRawY();
                        rltTop = liner_top.getTop();
                        break;
                    case MotionEvent.ACTION_UP:
                        break;
                }
                return false;
            }
        });
    }

    private void choiceStartPlace(LinearLayout line_start) {
        PopupOpenHelper openHelper = new PopupOpenHelper(getContext(), line_start, R.layout.popup_choice_start);
        openHelper.openPopupWindowWithView(true, 0, (int) line_start.getY() + line_start.getHeight());

    }

    private void choiceEndPlace() {

    }

    private void screenAllTerm() {

    }
}
