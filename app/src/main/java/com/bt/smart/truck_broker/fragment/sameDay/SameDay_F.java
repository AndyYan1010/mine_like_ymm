package com.bt.smart.truck_broker.fragment.sameDay;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.utils.PopupOpenHelper;


/**
 * @创建者 AndyYan
 * @创建时间 2018/11/6 8:32
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SameDay_F extends Fragment implements View.OnClickListener {
    private View         mRootView;
    private TextView     tv_title;
    private LinearLayout line_start;
    private LinearLayout line_end;
    private LinearLayout line_screen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.sameday_f, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        tv_title = mRootView.findViewById(R.id.tv_title);
        line_start = mRootView.findViewById(R.id.line_start);
        line_end = mRootView.findViewById(R.id.line_end);
        line_screen = mRootView.findViewById(R.id.line_screen);
    }

    private void initData() {
        tv_title.setText("最新货源");
        line_start.setOnClickListener(this);
        line_end.setOnClickListener(this);
        line_screen.setOnClickListener(this);
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

    private void choiceStartPlace(LinearLayout line_start) {
        PopupOpenHelper openHelper = new PopupOpenHelper(getContext(), line_start, R.layout.popup_choice_start);
        openHelper.openPopupWindowWithView(true, 0, (int) line_start.getY() + line_start.getHeight());

    }

    private void choiceEndPlace() {

    }

    private void screenAllTerm() {

    }
}
