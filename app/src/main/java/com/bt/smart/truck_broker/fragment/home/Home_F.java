package com.bt.smart.truck_broker.fragment.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.utils.SoundPoolUtil;

/**
 * @创建者 AndyYan
 * @创建时间 2018/5/22 16:41
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class Home_F extends Fragment implements View.OnClickListener {
    private View     mRootView;
    private TextView tv_mine;
    private int REQUEST_FINE_LOACTION = 2001;//申请定位权限的识别码

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.home_f, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        tv_mine = mRootView.findViewById(R.id.tv_mine);
    }

    private void initData() {

//        //获取天气信息
//        //申请定位权限
//        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
//                != PackageManager.PERMISSION_GRANTED) {//未开启定位权限
//            Toast.makeText(getContext(), "未开启定位权限,不能获取到天气信息", Toast.LENGTH_LONG).show();
//            //开启定位权限,200是标识码
//            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOACTION);
//        } else {
//
//        }
    }

    @Override
    public void onClick(View view) {
        SoundPoolUtil.play(0);
        switch (view.getId()) {

        }
    }
}
