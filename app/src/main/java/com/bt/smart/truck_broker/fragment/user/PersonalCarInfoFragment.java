package com.bt.smart.truck_broker.fragment.user;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bt.smart.truck_broker.MyApplication;
import com.bt.smart.truck_broker.NetConfig;
import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.messageInfo.UpDataDriverInfo;
import com.bt.smart.truck_broker.utils.HttpOkhUtils;
import com.bt.smart.truck_broker.utils.MyFragmentManagerUtil;
import com.bt.smart.truck_broker.utils.ProgressDialogUtil;
import com.bt.smart.truck_broker.utils.RequestParamsFM;
import com.bt.smart.truck_broker.utils.ToastUtils;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Request;

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
    private ImageView img_up_card;
    private EditText  et_name;
    private TextView  tv_carmodel;
    private TextView  tv_carlength;
    private TextView  tv_submit;
    private String    carno;//车牌号
    private String    headUrl;//头像照地址
    private String    driverUrl;//驾驶证地址
    private String    personalNo;//身份证号
    private String    userName;//姓名

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
        img_up_card = mRootView.findViewById(R.id.img_up_card);
        et_name = mRootView.findViewById(R.id.et_name);
        tv_carmodel = mRootView.findViewById(R.id.tv_carmodel);
        tv_carlength = mRootView.findViewById(R.id.tv_carlength);
        tv_submit = mRootView.findViewById(R.id.tv_submit);

    }

    private void initData() {
        tv_title.setText("司机身份认证");
        img_back.setVisibility(View.VISIBLE);
        img_back.setOnClickListener(this);
        img_up_card.setOnClickListener(this);
        tv_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                MyFragmentManagerUtil.closeTopFragment(this);
                break;
            case R.id.img_up_card:
                //拍摄驾驶证

                break;
            case R.id.tv_submit:
                //提交
                submitDriveInfo();
                break;
        }
    }


    private void submitDriveInfo() {
        carno = String.valueOf(et_name.getText()).trim();
        if ("".equals(carno) || "请输入车牌号".equals(carno)) {
            ToastUtils.showToast(getContext(), "车牌号不能为空");
            return;
        }
        RequestParamsFM params = new RequestParamsFM();
        params.put("checkStatus", "0");
        params.put("fphoto", "");//头像
        params.put("driver_license", "");//驾驶证
        params.put("driving_license", "");//行驶证
        params.put("fcarno", carno);//车牌号
        params.put("fname", userName);//姓名
        params.put("id_number", personalNo);//身份证号
        params.put("fcartype", "");//车型
        params.put("fcarlength", "");//车长
        params.setUseJsonStreamer(true);
        RequestParamsFM headParams = new RequestParamsFM();
        headParams.put("X-AUTH-TOKEN", MyApplication.userToken);
        HttpOkhUtils.getInstance().doPutWithHeader(NetConfig.REGISTERDRIVERCONTROLLER, headParams, params, new HttpOkhUtils.HttpCallBack() {
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
                UpDataDriverInfo upDataDriverInfo = gson.fromJson(resbody, UpDataDriverInfo.class);
                ToastUtils.showToast(getContext(), upDataDriverInfo.getMessage());
                if (upDataDriverInfo.isOk()) {
                    getActivity().finish();
                }
            }
        });
    }

    public void setSomeInfo(String img_headUrl, String img_driverUrl, String user_name, String personNo) {
        headUrl = img_headUrl;
        driverUrl = img_driverUrl;
        userName = user_name;
        personalNo = personNo;
    }
}
