package com.bt.smart.truck_broker.activity.userAct;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bt.smart.truck_broker.BaseActivity;
import com.bt.smart.truck_broker.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/8 15:00
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class GetFacePhotoActivity extends BaseActivity implements View.OnClickListener, Camera.PreviewCallback {
    private SurfaceView sfview;
    private ImageView   img_back;
    private TextView    tv_sure;
    private Camera      mCamera;
    private boolean     bfrontSwitch;
    private Bitmap      bmp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_face);
        setView();
        setData();
    }

    private void setView() {
        sfview = (SurfaceView) findViewById(R.id.sfview);
        img_back = (ImageView) findViewById(R.id.img_back);
        tv_sure = (TextView) findViewById(R.id.tv_sure);
    }

    private void setData() {
        img_back.setOnClickListener(this);
        tv_sure.setOnClickListener(this);
        //获取前置摄像头，显示在SurfaceView上
        setSurFaceView();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.tv_sure:
                //拍摄,获取相机图片
                getCameraPic();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCamera != null) {
            mCamera.setPreviewCallback(null);
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
    }

    private void getCameraPic() {
        if (null!=bmp) {
            //将bitmap保存，记录照片本地地址，留待之后上传

        }
    }

    private void setSurFaceView() {
        //判断是否有前置摄像头
        bfrontSwitch = isHasFrontCamera();
        if (mCamera == null) {
            if (bfrontSwitch) {
                mCamera = Camera.open(1);//前置
                //                rotation = 270;
            } else {
                mCamera = Camera.open(0);//后置
                //                rotation = 90;
            }
        }
        mCamera.setDisplayOrientation(90);
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPreviewFormat(ImageFormat.NV21);//default默认为21，所有手机均支持NV21
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        parameters.setPreviewSize(supportedPreviewSizes.get(0).width, supportedPreviewSizes.get(0).height);//设置预览分辨率
        parameters.setPreviewFrameRate(25);
        if (!bfrontSwitch) {//后置需要自动对焦，否则人脸采集照片模糊
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);
        }
        mCamera.setParameters(parameters);
        mCamera.setPreviewCallback(this);//开启Camera预览回调，重写onPreviewFrame获取相机回调
        mCamera.startPreview();//开启预览
        mCamera.cancelAutoFocus();//聚焦
        //已打开相机

        final SurfaceHolder mSurfaceHolder = sfview.getHolder();//获取holder参数
        mSurfaceHolder.addCallback(new SurfaceHolder.Callback() {//设置holder的回调
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                startPreview(mSurfaceHolder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
                stopPreview();
            }
        });

    }

    private void startPreview(SurfaceHolder mSurfaceHolder) {
        try {
            mCamera.setPreviewDisplay(mSurfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void stopPreview() {
        try {
            finish();
        } catch (Exception e) {
        }
    }

    private boolean isHasFrontCamera() {
        boolean hasFrontCarmera = false;
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                hasFrontCarmera = true;
            }
        }
        return hasFrontCarmera;
    }

    @Override
    public void onPreviewFrame(byte[] bytes, Camera camera) {
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        YuvImage image = new YuvImage(bytes, ImageFormat.NV21, previewSize.width, previewSize.height, null);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        image.compressToJpeg(new Rect(0, 0, previewSize.width, previewSize.height), 80, stream);
        bmp = BitmapFactory.decodeByteArray(stream.toByteArray(), 0, stream.size());
    }
}
