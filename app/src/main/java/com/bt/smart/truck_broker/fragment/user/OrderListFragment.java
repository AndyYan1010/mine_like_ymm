package com.bt.smart.truck_broker.fragment.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bt.smart.truck_broker.MyApplication;
import com.bt.smart.truck_broker.NetConfig;
import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.adapter.RecyDriverOrderAdapter;
import com.bt.smart.truck_broker.utils.HttpOkhUtils;
import com.bt.smart.truck_broker.utils.RequestParamsFM;
import com.bt.smart.truck_broker.utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/22 19:55
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class OrderListFragment extends Fragment {
    private View                   mRootView;
    private SwipeRefreshLayout     swiperefresh;
    private RecyclerView           recyview;
    private RecyDriverOrderAdapter orderAdapter;
    private List                   mData;
    private int                    mType;//fragment需要展示的订单种类//0接单、1运输、2待确认、3已取消、4签收

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.frame_order_list, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        swiperefresh = mRootView.findViewById(R.id.swiperefresh);
        recyview = mRootView.findViewById(R.id.recyview);

    }

    private void initData() {
        //初始化recyclerview
        initRecyclerview();
        //刷新控件
        setSwipRefresh();
    }

    private void setSwipRefresh() {
        swiperefresh.setColorSchemeColors(getResources().getColor(R.color.blue_icon), getResources().getColor(R.color.yellow_40), getResources().getColor(R.color.red_160));
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //获取司机个人订单列表
                getDrivierOrderList(MyApplication.userID, "" + mType);
            }
        });
    }

    private void initRecyclerview() {
        mData = new ArrayList();
        recyview.setLayoutManager(new LinearLayoutManager(getContext()));
        orderAdapter = new RecyDriverOrderAdapter(R.layout.adpter_sameday_order, getContext(), mData);
        recyview.setAdapter(orderAdapter);
    }

    private void getDrivierOrderList(String userID, String type) {
        swiperefresh.setRefreshing(true);
        RequestParamsFM heardParam = new RequestParamsFM();
        heardParam.put("X-AUTH-TOKEN  ", MyApplication.userToken);
        RequestParamsFM params = new RequestParamsFM();
        params.put("id", userID);
        params.put("status", type);
        HttpOkhUtils.getInstance().doGetWithHeadParams(NetConfig.DRIVERORDERCONTROLLER_ORDER, heardParam, params, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                swiperefresh.setRefreshing(false);
                ToastUtils.showToast(getContext(), "网络连接错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                swiperefresh.setRefreshing(false);
                if (code != 200) {
                    ToastUtils.showToast(getContext(), "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();

            }
        });
    }

    public void setType(int type) {
        mType = type;
    }

    public void refreshData() {
        //获取司机个人订单列表
        getDrivierOrderList(MyApplication.userID, "" + mType);
    }
}
