package com.bt.smart.truck_broker.fragment.sameDay;

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

import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.adapter.RecyOrderAdapter;
import com.bt.smart.truck_broker.utils.PopupOpenHelper;
import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;


/**
 * @创建者 AndyYan
 * @创建时间 2018/11/6 8:32
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SameDay_F extends Fragment implements View.OnClickListener {
    private View             mRootView;
    private TextView         tv_title;
    private LinearLayout     liner_top;
    private RelativeLayout   rlt_title;
    private LinearLayout     liner_term;
    private LinearLayout     line_start;
    private LinearLayout     line_end;
    private LinearLayout     line_screen;
    private RecyclerView     rec_order;
    private RecyOrderAdapter orderAdapter;
    private List             mData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.sameday_f, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        tv_title = mRootView.findViewById(R.id.tv_title);
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
        mData = new ArrayList();
        mData.add("");
        rec_order.setLayoutManager(new LinearLayoutManager(getContext()));
        orderAdapter = new RecyOrderAdapter(R.layout.adpter_sameday_order, getContext(), mData);
        rec_order.setAdapter(orderAdapter);
        orderAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()){
                    case R.id.list_item:
                        //查看详情

                        break;
                }
            }
        });
        //设置rec_order滑动事件
        setRecyclerviewMoveEvent();
        //获取订单列表信息
        getOrderList();
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

    private void getOrderList() {

    }

    int scDownY;
    int scMoveY;
    int rltTop;
    int rltBot;

    private void setRecyclerviewMoveEvent() {
        rec_order.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        scDownY = (int) motionEvent.getRawY();
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
