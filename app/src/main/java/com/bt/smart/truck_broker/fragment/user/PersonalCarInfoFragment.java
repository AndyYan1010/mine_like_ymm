package com.bt.smart.truck_broker.fragment.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.utils.MyFragmentManagerUtil;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/8 16:39
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class PersonalCarInfoFragment extends Fragment implements View.OnClickListener {
    private View      mRootView;
    private TextView  tv_title;
    private ImageView img_back;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.frame_personal_car_info, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        img_back = mRootView.findViewById(R.id.img_back);
        tv_title = mRootView.findViewById(R.id.tv_title);

    }

    private void initData() {
        tv_title.setText("司机身份认证");
        img_back.setVisibility(View.VISIBLE);
        img_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_back:
                MyFragmentManagerUtil.closeTopFragment(this);
                break;
        }
    }
}
