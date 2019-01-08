package com.bt.smart.truck_broker.fragment.user;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.activity.userAct.GetDriveCardPhotoActivity;
import com.bt.smart.truck_broker.activity.userAct.GetFacePhotoActivity;
import com.bt.smart.truck_broker.utils.ToastUtils;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/8 9:54
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class PersonalInfoFragment extends Fragment implements View.OnClickListener {
    private View      mRootView;
    private ImageView img_back;
    private TextView  tv_title;
    private ImageView img_up_head;
    private ImageView img_up_card;
    private EditText  et_name;
    private EditText  et_code;
    private TextView  tv_submit;
    private int MY_PERMISSIONS_REQUEST_CALL_PHONE2 = 10087;//照相权限申请码
    private int REQUEST_FOR_FACE                   = 10086;
    private int RESULT_FOR_FACE                    = 10088;
    private String mImageFileUrl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mRootView = LayoutInflater.from(getActivity()).inflate(R.layout.frame_personal_info, null);
        initView();
        initData();
        return mRootView;
    }

    private void initView() {
        img_back = mRootView.findViewById(R.id.img_back);
        tv_title = mRootView.findViewById(R.id.tv_title);
        img_up_head = mRootView.findViewById(R.id.img_up_head);
        img_up_card = mRootView.findViewById(R.id.img_up_card);
        et_name = mRootView.findViewById(R.id.et_name);
        et_code = mRootView.findViewById(R.id.et_code);
        tv_submit = mRootView.findViewById(R.id.tv_submit);
    }

    private void initData() {
        img_back.setVisibility(View.VISIBLE);
        tv_title.setText("司机身份认证");
        img_back.setOnClickListener(this);
        img_up_head.setOnClickListener(this);
        img_up_card.setOnClickListener(this);
        tv_submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                getActivity().finish();
                break;
            case R.id.img_up_head:
                //上传人脸头像,人脸活体检测(暂无)
                toGetFacePic();
                break;
            case R.id.img_up_card:
                //上传驾驶证
                toPhotoDriveCard();
                break;
            case R.id.tv_submit:
                //下一步，填写车辆信息
                toWriteCarInfo();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (REQUEST_FOR_FACE == requestCode && resultCode == RESULT_FOR_FACE) {
            mImageFileUrl = data.getStringExtra("face_pic_url");
        }
    }

    private void toWriteCarInfo() {
        PersonalCarInfoFragment personalCarFt = new PersonalCarInfoFragment();
        FragmentTransaction ftt = getFragmentManager().beginTransaction();
        ftt.add(R.id.frame, personalCarFt, "personalCarFt");
        ftt.commit();
    }

    private void toGetFacePic() {
        //第二个参数是需要申请的权限
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //权限还没有授予，需要在这里写申请权限的代码
            ToastUtils.showToast(getContext(),"面部认证功能，需要拍摄照片，请开启手机相机权限!");
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE2);
        } else {
            Intent intent = new Intent(getContext(), GetFacePhotoActivity.class);
            startActivityForResult(intent, REQUEST_FOR_FACE);
            //            String mFilePath = Environment.getExternalStorageDirectory().getPath();//获取SD卡路径
            //            long photoTime = System.currentTimeMillis();
            //            mFilePath = mFilePath + "/temp" + photoTime + ".jpg";//指定路径
            //权限已经被授予，在这里直接写要执行的相应方法即可
            //            //调用相机
            //            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //            Uri photoUri = Uri.fromFile(new File(mFilePath)); // 传递路径
            //            intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);// 更改系统默认存储路径
        }
    }

    private void toPhotoDriveCard() {
        //第二个参数是需要申请的权限
        if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //权限还没有授予，需要在这里写申请权限的代码
            ToastUtils.showToast(getContext(),"面部认证功能，需要拍摄照片，请开启手机相机权限!");
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE2);
        } else {
            Intent intent = new Intent(getContext(), GetDriveCardPhotoActivity.class);
            startActivityForResult(intent, REQUEST_FOR_FACE);
        }
    }
}
