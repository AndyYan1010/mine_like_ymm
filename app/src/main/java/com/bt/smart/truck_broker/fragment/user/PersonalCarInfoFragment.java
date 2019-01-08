package com.bt.smart.truck_broker.fragment.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bt.smart.truck_broker.R;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/8 16:39
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class PersonalCarInfoFragment extends Fragment {
    private View mRootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.frame_personal_car_info, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {

    }

    private void initData() {

    }
}
