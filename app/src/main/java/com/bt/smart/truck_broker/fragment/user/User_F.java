package com.bt.smart.truck_broker.fragment.user;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bt.smart.truck_broker.MyApplication;
import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.activity.LoginActivity;
import com.bt.smart.truck_broker.activity.userAct.AuthenticationActivity;
import com.bt.smart.truck_broker.utils.SpUtils;


/**
 * @创建者 AndyYan
 * @创建时间 2018/5/22 16:42
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class User_F extends Fragment implements View.OnClickListener {
    private View           mRootView;
    private TextView       tv_title;
    private ImageView      img_head;
    private TextView       tv_phone;
    private TextView       tv_isCheck;
    private TextView       tv_warn;
    private TextView       tv_submit;
    private RelativeLayout rtv_address;
    private RelativeLayout rtv_phone;
    private RelativeLayout rtv_serv;
    private RelativeLayout rtv_about;
    private RelativeLayout rtv_exit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.user_f, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        tv_title = mRootView.findViewById(R.id.tv_title);
        img_head = mRootView.findViewById(R.id.img_head);
        tv_phone = mRootView.findViewById(R.id.tv_phone);
        tv_isCheck = mRootView.findViewById(R.id.tv_isCheck);
        tv_warn = mRootView.findViewById(R.id.tv_warn);
        tv_submit = mRootView.findViewById(R.id.tv_submit);
        rtv_address = mRootView.findViewById(R.id.rtv_address);
        rtv_phone = mRootView.findViewById(R.id.rtv_phone);
        rtv_serv = mRootView.findViewById(R.id.rtv_serv);
        rtv_about = mRootView.findViewById(R.id.rtv_about);
        rtv_exit = mRootView.findViewById(R.id.rtv_exit);

    }

    private void initData() {
        tv_title.setText("我的");
        tv_submit.setOnClickListener(this);
        rtv_address.setOnClickListener(this);
        rtv_phone.setOnClickListener(this);
        rtv_serv.setOnClickListener(this);
        rtv_about.setOnClickListener(this);
        rtv_exit.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_submit:
                //跳转身份认证界面
                toSubmitPersonInfo();
                break;
            case R.id.rtv_address:
                //跳转收货地址界面
                toCompleteAddress();
                break;
            case R.id.rtv_phone:
                //修改手机号
                changePhone();
                break;
            case R.id.rtv_serv:
                //电话联系客服
                contactService();
                break;
            case R.id.rtv_about:
                //关于我们
                aboutUs();
                break;
            case R.id.rtv_exit:
                //退出登录
                exitLogin();
                break;
        }
    }

    private void exitLogin() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext(), AlertDialog.THEME_HOLO_LIGHT);
        builder.setTitle("温馨提示");
        builder.setMessage("您确定要退出当前登录帐号吗？");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                SpUtils.putBoolean(getContext(), "isRem", false);
                MyApplication.isLogin = 0;
                Intent intent = new Intent();
                intent.setClass(getContext(), LoginActivity.class);
                startActivity(intent);
                ((Activity) getContext()).finish();
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        }).create().show();
    }

    private void toSubmitPersonInfo() {
        Intent intent = new Intent(getActivity(), AuthenticationActivity.class);
        startActivity(intent);
    }

    private void toCompleteAddress() {

    }

    private void changePhone() {

    }

    private void contactService() {

    }

    private void aboutUs() {

    }


}
