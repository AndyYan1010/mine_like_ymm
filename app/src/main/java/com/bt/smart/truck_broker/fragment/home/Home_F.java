package com.bt.smart.truck_broker.fragment.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bt.smart.truck_broker.MyApplication;
import com.bt.smart.truck_broker.NetConfig;
import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.activity.homeAct.FindByLinesActivity;
import com.bt.smart.truck_broker.activity.homeAct.SelectPlaceAndCarActivity;
import com.bt.smart.truck_broker.adapter.LvLinesAdapter;
import com.bt.smart.truck_broker.messageInfo.SearchDriverLinesInfo;
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
    private boolean      canEdit;//是否编辑路线
    private ListView     lv_line;//线路列表
    private TextView     tv_addline;
    private int REQUEST_FOR_SELECT_LINES = 10066;//设置线路响应码
    private int Result_FOR_SELECT_LINES  = 10067;//设置线路响应值
    private List<SearchDriverLinesInfo.DataBean> mData;
    private LvLinesAdapter                       linesAdapter;

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
        //初始化路线
        initLinesData();

        tv_addline.setOnClickListener(this);
        tv_edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SoundPoolUtil.play(0);
        switch (view.getId()) {
            case R.id.tv_addline:
                //创建司机行程
                createDriverLine();
                break;
            case R.id.tv_edit:
                //编辑路线
                editLines();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_FOR_SELECT_LINES && resultCode == Result_FOR_SELECT_LINES) {
            //搜索最新线路列表
            //获取个人线路
            getPersonalLines();
        }
    }

    private void editLines() {
        if (!canEdit) {
            canEdit = true;
            tv_edit.setText("取消编辑");
            for (SearchDriverLinesInfo.DataBean bean : mData) {
                bean.setCanDel(true);
            }
        } else {
            canEdit = false;
            tv_edit.setText("编辑");
            for (SearchDriverLinesInfo.DataBean bean : mData) {
                bean.setCanDel(false);
            }
        }
        linesAdapter.notifyDataSetChanged();
    }

    private void initLinesData() {
        mData = new ArrayList();
        linesAdapter = new LvLinesAdapter(getContext(), mData, this);
        lv_line.setAdapter(linesAdapter);
        lv_line.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转线路查找货源列表
                Intent intent = new Intent(getContext(), FindByLinesActivity.class);
                intent.putExtra("lineID", mData.get(i).getId());
                intent.putExtra("lineName", mData.get(i).getOrigin() + "  →  " + mData.get(i).getDestination());
                startActivity(intent);
            }
        });
        linear_lines.setVisibility(View.GONE);
        //获取个人线路
        getPersonalLines();
    }

    private void createDriverLine() {
        //跳转添加路线界面
        Intent intent = new Intent(getContext(), SelectPlaceAndCarActivity.class);
        startActivityForResult(intent, REQUEST_FOR_SELECT_LINES);
    }

    private void getPersonalLines() {
        RequestParamsFM headParams = new RequestParamsFM();
        headParams.put("X-AUTH-TOKEN", MyApplication.userToken);
        HttpOkhUtils.getInstance().doGetWithOnlyHeader(NetConfig.DRIVERJOURNEYCONTROLLER + "/getRoute/" + MyApplication.userID, headParams, new HttpOkhUtils.HttpCallBack() {
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
                SearchDriverLinesInfo searchDriverLinesInfo = gson.fromJson(resbody, SearchDriverLinesInfo.class);
                ToastUtils.showToast(getContext(), searchDriverLinesInfo.getMessage());
                if (searchDriverLinesInfo.isOk()) {
                    if (searchDriverLinesInfo.getData().size() > 0) {
                        linear_lines.setVisibility(View.VISIBLE);
                        linear_tips.setVisibility(View.GONE);
                        tv_linesnum.setText("我的路线(" + searchDriverLinesInfo.getData().size() + "/10)");
                        mData.addAll(searchDriverLinesInfo.getData());
                        linesAdapter.notifyDataSetChanged();
                    } else {
                        linear_lines.setVisibility(View.GONE);
                        linear_tips.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    public void setUIChange() {
        linear_lines.setVisibility(View.GONE);
        linear_tips.setVisibility(View.VISIBLE);
    }
}
