package com.bt.smart.truck_broker.fragment.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bt.smart.truck_broker.MyApplication;
import com.bt.smart.truck_broker.NetConfig;
import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.adapter.LvLinesAdapter;
import com.bt.smart.truck_broker.utils.HttpOkhUtils;
import com.bt.smart.truck_broker.utils.ProgressDialogUtil;
import com.bt.smart.truck_broker.utils.RequestParamsFM;
import com.bt.smart.truck_broker.utils.SoundPoolUtil;
import com.bt.smart.truck_broker.utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * @创建者 AndyYan
 * @创建时间 2018/5/22 16:41
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class Home_F extends Fragment implements View.OnClickListener {
    private View         mRootView;
    private TextView     tv_mine;
    private LinearLayout linear_tips;//没有线路时的提醒
    private LinearLayout linear_lines;//有线路时需展示的view
    private TextView     tv_linesnum;//线路数
    private TextView     tv_edit;//编辑线路
    private ListView     lv_line;//线路列表
    private TextView     tv_addline;
    private int REQUEST_FINE_LOACTION = 2001;//申请定位权限的识别码
    private List           mData;
    private LvLinesAdapter linesAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.home_f, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        tv_mine = mRootView.findViewById(R.id.tv_mine);
        linear_tips = mRootView.findViewById(R.id.linear_tips);
        linear_lines = mRootView.findViewById(R.id.linear_lines);
        tv_linesnum = mRootView.findViewById(R.id.tv_linesnum);
        tv_edit = mRootView.findViewById(R.id.tv_edit);
        lv_line = mRootView.findViewById(R.id.lv_line);
        tv_addline = mRootView.findViewById(R.id.tv_addline);
    }

    private void initData() {
        mData = new ArrayList();
        linesAdapter = new LvLinesAdapter(getContext(), mData);
        lv_line.setAdapter(linesAdapter);
        linear_lines.setVisibility(View.GONE);
        //获取个人线路
        getPersonalLines();
    }

    @Override
    public void onClick(View view) {
        SoundPoolUtil.play(0);
        switch (view.getId()) {
            case R.id.tv_addline:

                break;
        }
    }

    private void getPersonalLines() {
        RequestParamsFM params = new RequestParamsFM();
        params.put("", MyApplication.userID);
        HttpOkhUtils.getInstance().doGetWithParams(NetConfig.LOGINURL, params, new HttpOkhUtils.HttpCallBack() {
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
//                linear_tips.setVisibility(View.GONE);
//                linear_lines.setVisibility(View.VISIBLE);
//                mData.add("");
//                linesAdapter.notifyDataSetChanged();
            }
        });
    }
}
