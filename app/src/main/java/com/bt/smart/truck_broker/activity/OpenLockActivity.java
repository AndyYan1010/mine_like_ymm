package com.bt.smart.truck_broker.activity;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bt.smart.truck_broker.BaseActivity;
import com.bt.smart.truck_broker.MyApplication;
import com.bt.smart.truck_broker.NetConfig;
import com.bt.smart.truck_broker.R;
import com.bt.smart.truck_broker.ble.BLEDevice;
import com.bt.smart.truck_broker.ble.GattAttributes;
import com.bt.smart.truck_broker.messageInfo.BlueMacInfo;
import com.bt.smart.truck_broker.utils.CRCUtil;
import com.bt.smart.truck_broker.utils.CommandUtil;
import com.bt.smart.truck_broker.utils.HttpOkhUtils;
import com.bt.smart.truck_broker.utils.RequestParamsFM;
import com.bt.smart.truck_broker.utils.ToastUtils;
import com.github.ring.CircleProgress;
import com.google.gson.Gson;
import com.uuzuche.lib_zxing.activity.CodeUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

/**
 * @创建者 AndyYan
 * @创建时间 2019/2/18 15:09
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class OpenLockActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "OpenLockActivity";
    private String         mOrderID;
    private ImageView      img_back;
    private TextView       tv_title;
    private ImageView      img_scan;
    private CircleProgress circleprogress;
    private Handler        mProhandler;
    private int count                              = 60;//搜索时间、单位秒
    private int MY_PERMISSIONS_REQUEST_CALL_PHONE2 = 1001;//申请照相机权限结果
    private int REQUEST_CODE                       = 1003;//接收扫描结果

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_lock);
        initView();
        initData();
    }

    private void initView() {
        img_back = findViewById(R.id.img_back);
        tv_title = findViewById(R.id.tv_title);
        img_scan = findViewById(R.id.img_scan);
        circleprogress = findViewById(R.id.circleprogress);
    }

    private void initData() {
        mOrderID = getIntent().getStringExtra("orderID");
        tv_title.setText("开锁");
        //初始化进度条
        mProhandler = new Handler();
        circleprogress.setProgress(0.0f);
        circleprogress.setMaxProgress(60);

        mBtData = new ArrayList();

        img_back.setOnClickListener(this);
        img_scan.setOnClickListener(this);
        //先开启蓝牙搜索
        //searchBlueDevice();
        initBLE();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.img_scan:
                //扫描二维码，提交服务器，获取对应蓝牙mac地址
                getScanCode();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        needLoactionRight();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mScanning) {
            scanLeDevice(false);
        }
        LocalBroadcastManager.getInstance(this).unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProhandler.removeMessages(0);
        mProhandler = null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        /**
         * 处理二维码扫描结果
         */
        if (requestCode == REQUEST_CODE) {
            //处理扫描结果，将扫描获取到的编码上传给服务器
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    //上传给服务器 result
                    sendCode2Service(result);
                    //开始进度条读秒
                    startReadScend();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(this, "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {//requestCode == REQUEST_ENABLE
            // 请求定位权限
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//允许
                //搜索
                startSearchBluetooth();
            } else {
                finish();
                ToastUtils.showToast(this, "您未授予权限");
            }
        }
    }

    private boolean isGetKey = false;//是否已获取通讯指令

    private void startReadScend() {
        mProhandler.postDelayed(new Runnable() {
            public void run() {
                mProhandler.postDelayed(this, 1000);//递归执行，一秒执行一次
                count--;
                circleprogress.setProgress(60 - count);
                if (count == 0) {
                    //连接时间超过一分钟，可关闭界面
                    circleprogress.setProgress(60);
                    mProhandler.removeCallbacks(this);
                } else {
                    //在一分钟内，可连接蓝牙开锁
                    if (isGetKey) {
                        lastTepOpenBlue();
                    }
                }
            }
        }, 1000);
    }

    private void lastTepOpenBlue() {
        sendOpenCommand();
    }

    private void sendOpenCommand() {
        if (mBLEGatt != null) {
            int uid = 1;
            long timestamp = System.currentTimeMillis() / 1000;
            byte[] crcOrder = CommandUtil.getCRCOpenCommand(uid, bleCKey, timestamp);
            Log.i(TAG, "sendOpenCommand: openComm=" + getCommForHex(crcOrder));
            mBLEGCWrite.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            mBLEGCWrite.setValue(crcOrder);
            mBLEGatt.writeCharacteristic(mBLEGCWrite);
        } else {
            Toast.makeText(this, "请退出重新连接蓝牙设备", Toast.LENGTH_SHORT).show();
        }

    }

    private void initBLE() {
        final BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        mBluetoothAdapter = bluetoothManager.getAdapter();
        if (mBluetoothAdapter == null || !mBluetoothAdapter.isEnabled()) {
            Intent enableBTIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBTIntent, 1);
        }

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_CONNECT_BLE);
        intentFilter.addAction(ACTION_LOCK_CLOSE);
        intentFilter.addAction(ACTION_GET_LOCK_KEY);
        intentFilter.addAction(ACTION_DISCONNECT);
        intentFilter.addAction(ACTION_BLE_LOCK_OPEN_STATUS);

        LocalBroadcastManager.getInstance(this).registerReceiver(broadcastReceiver, intentFilter);
    }

    private List<BLEDevice> mBtData;//存放搜索到的蓝牙

    private void needLoactionRight() {
        //判断是否已经赋予权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //如果应用之前请求过此权限但用户拒绝了请求，此方法将返回 true。
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                //这里可以写个对话框之类的项向用户解释为什么要申请权限，并在对话框的确认键后续再次申请权限
                ToastUtils.showToast(this, "请手动开启相关权限");
            } else {
                //申请权限，字符串数组内是一个或多个要申请的权限，1是申请权限结果的返回参数，在onRequestPermissionsResult可以得知申请结果
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,}, 1);
            }
        } else {
            startSearchBluetooth();
        }
    }

    private void startSearchBluetooth() {
        if (!mScanning) {
            mBtData.clear();
            scanLeDevice(true);
        }
    }

    private Handler mHandler = new Handler();
    private boolean          mScanning;
    private BluetoothAdapter mBluetoothAdapter;
    // Stops scanning after 10 seconds
    private static final long                            SCAN_PERIOD     = 10000; // 10s for scanning
    private              BluetoothAdapter.LeScanCallback mLescanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            final BLEDevice bleDevice = new BLEDevice(device, rssi);
            mBtData.add(bleDevice);
        }
    };

    //搜索蓝牙设备
    private void scanLeDevice(final boolean enable) {
        if (enable) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mScanning = false;
                    mBluetoothAdapter.stopLeScan(mLescanCallback);
                }
            }, SCAN_PERIOD);
            mScanning = true;
            mBluetoothAdapter.startLeScan(mLescanCallback);//扫描低功耗蓝牙设备
            //正在扫描
        } else {
            mScanning = false;
            mBluetoothAdapter.stopLeScan(mLescanCallback);
            //终止扫描了
        }
    }

    //扫描二维码
    private void getScanCode() {
        //第二个参数是需要申请的权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //权限还没有授予，需要在这里写申请权限的代码
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE2);
        } else {
            Intent intent = new Intent(this, SaomiaoUIActivity.class);//这是一个自定义的扫描界面，扫描UI框放大了。
            startActivityForResult(intent, REQUEST_CODE);
        }
    }

    private void sendCode2Service(String result) {
        //获取到mac地址后，连接蓝牙
        RequestParamsFM headParam = new RequestParamsFM();
        headParam.put("X-AUTH-TOKEN", MyApplication.userToken);
        HttpOkhUtils.getInstance().doGetWithOnlyHeader(NetConfig.DRIVERORDERCONTROLLER + "/" + result + "/" + mOrderID, headParam, new HttpOkhUtils.HttpCallBack() {
            @Override
            public void onError(Request request, IOException e) {
                ToastUtils.showToast(OpenLockActivity.this, "网络错误");
            }

            @Override
            public void onSuccess(int code, String resbody) {
                if (code != 200) {
                    ToastUtils.showToast(OpenLockActivity.this, "网络错误" + code);
                    return;
                }
                Gson gson = new Gson();
                BlueMacInfo blueMacInfo = gson.fromJson(resbody, BlueMacInfo.class);
                ToastUtils.showToast(OpenLockActivity.this, blueMacInfo.getMessage());
                if (blueMacInfo.isOk()) {
                    //获取到mac地址后，连接蓝牙开锁
                    String data = blueMacInfo.getData();
                    if (null != data && !"".equals(data))
                        openBlueDevice(data);
                }
            }
        });
    }

    private int whichBle = -1;
    private BluetoothGatt mBLEGatt;

    private void openBlueDevice(String data) {
        for (int i = 0; i < mBtData.size(); i++) {
            BLEDevice bleDevice = mBtData.get(i);
            if (bleDevice.getDevice().getAddress().equals(data)) {
                //订单的蓝牙设备在本地搜索到了
                whichBle = i;
                break;
            }
        }

        if (whichBle != -1) {
            scanLeDevice(false);
            //发起连接
            mBLEGatt = mBtData.get(whichBle).getDevice().connectGatt(this, false, mGattCallback);
        }
    }

    private BluetoothGattCharacteristic mBLEGCWrite;
    private BluetoothGattCharacteristic mBLEGCRead;
    private static final String ACTION_CONNECT_BLE = "com.omni.bleDemo.ACTION_CONNECT_BLE";
    private static final String ACTION_DISCONNECT  = "com.omni.bleDemo.ACTION_DISCONNECT";

    private void sendLocalBroadcast(String action) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(action));
    }

    private void sendLocalBroadcast(Intent intent) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    //蓝牙返回接收器
    private final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        @Override
        public void onConnectionStateChange(BluetoothGatt gatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                //发送本地连接蓝牙广播
                sendLocalBroadcast(ACTION_CONNECT_BLE);
                gatt.discoverServices();
            } else {
                //                Log.i(TAG, "onConnectionStateChange: ble disconnection");
                //发送断开连接广播
                sendLocalBroadcast(ACTION_DISCONNECT);
            }
        }

        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status) {//发现服务后
            List<BluetoothGattService> services = gatt.getServices();
            for (BluetoothGattService bgs : services) {
                if (bgs.getUuid().equals(GattAttributes.UUID_SERVICE)) {
                    //service 6e400001-b5a3-f393-e0a9-e50e24dcca9e
                    //获取到蓝牙GATT对应服务
                    BluetoothGattService bleGattService = gatt.getService(GattAttributes.UUID_SERVICE);
                    if (bleGattService != null) {
                        //write 6e400002-b5a3-f393-e0a9-e50e24dcca9e
                        //蓝牙写入服务线
                        mBLEGCWrite = bleGattService.getCharacteristic(GattAttributes.UUID_CHARACTERISTIC_WRITE);

                        //Notify 1.6e400003-b5a3-f393-e0a9-e50e24dcca9e
                        //1. get read characteristic
                        //蓝牙接收读取线
                        mBLEGCRead = bleGattService.getCharacteristic(GattAttributes.UUID_CHARACTERISTIC_READ);
                        //2. descriptor 00002902-0000-1000-8000-00805f9b34fb
                        //2. set descriptor notify 设置描述符通知
                        BluetoothGattDescriptor descriptor = mBLEGCRead.getDescriptor(GattAttributes.UUID_NOTIFICATION_DESCRIPTOR);
                        descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

                        mBLEGatt.writeDescriptor(descriptor);
                    }
                } else if (bgs.getUuid().equals(GattAttributes.UUID_OBL2_SERVICE)) {
                    BluetoothGattService bleGattService = gatt.getService(GattAttributes.UUID_OBL2_SERVICE);

                    mBLEGCWrite = bleGattService.getCharacteristic(GattAttributes.UUID_OBL2_CHARACTERISTIC_WRITE);
                    //1.0783b03e-8535-b5a0-7140-a304d2495cb8
                    //1. get read characteristic
                    mBLEGCRead = bleGattService.getCharacteristic(GattAttributes.UUID_OBL2_CHARACTERISTIC_READ);
                    //2. descriptor 00002902-0000-1000-8000-00805f9b34fb
                    //2. set descriptor notify
                    BluetoothGattDescriptor descriptor = mBLEGCRead.getDescriptor(GattAttributes.UUID_NOTIFICATION_DESCRIPTOR);
                    descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                    mBLEGatt.writeDescriptor(descriptor);
                }
            }
        }

        @Override
        public void onDescriptorWrite(BluetoothGatt gatt, BluetoothGattDescriptor descriptor, int status) {
            //3. set characteristic notify
            gatt.setCharacteristicNotification(mBLEGCRead, true);
            //            Log.i(TAG, "onDescriptorWrite: request the ope key");
            int uid = 1; // user login id

            byte[] crcOrder = CommandUtil.getCRCKeyCommand2();
            //            Log.i(TAG, "onDescriptorWrite: GET KEY COMM=" + getCommForHex(crcOrder));
            mBLEGCWrite.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
            mBLEGCWrite.setValue(crcOrder);
            mBLEGatt.writeCharacteristic(mBLEGCWrite);
        }

        @Override
        public void onCharacteristicChanged(BluetoothGatt gatt, BluetoothGattCharacteristic characteristic) {
            byte[] values = characteristic.getValue();
            //            Log.i(TAG, "onCharacteristicChanged: values=" + getCommForHex(values));
            int start = 0;
            int copyLen = 0;
            for (int i = 0; i < values.length; i++) {
                if ((values[i] & 0xFF) == 0xFE) {
                    start = i;
                    int randNum = (values[i + 1] - 0x32) & 0xFF; //BF
                    int len = ((values[i + 4]) & 0xFF) ^ randNum;
                    copyLen = len + 7; //16+
                    break;
                }
            }
            if (copyLen == 0)
                return;
            byte[] real = new byte[copyLen];
            //创建了一个空数组real，在将values数组的第start位到第copyLen位 复制到目标数组real 0位开始
            System.arraycopy(values, start, real, 0, copyLen);//源数组  源数组要复制的起始位置  目标数组  目标数组开始位  复制的长度

            byte[] command = new byte[values.length - 2];
            command[0] = values[0]; // 包头
            if (CRCUtil.CheckCRC(real)) {
                // crc校验成功
                byte head = (byte) (real[1] - 0x32);
                command[1] = head;
                for (int i = 2; i < real.length - 2; i++) {
                    command[i] = (byte) (real[i] ^ head);
                }
                handCommand(command);
            } else {
                // CRC校验失败
                //                Log.i(TAG, "onCharacteristicChanged: CRC校验失败");
            }
        }
    };

    private void handCommand(byte[] command) {
        switch (command[3]) {
            case 0x11:
                // get key
                handKey(command);
                break;
            case 0x22:
                // lock 锁关闭后发来的信息
                handLockClose(command);
                break;
            case 0x21:
                handLockOpen(command);
                break;
        }
    }

    //秘钥
    private              byte   bleCKey             = 0;
    private static final String ACTION_GET_LOCK_KEY = "com.omni.bleDemo.ACTION_GET_LOCK_KEY";

    // get key 获取秘钥
    private void handKey(byte[] command) {
        //获取秘钥
        bleCKey = command[5];
        //        Log.i(TAG, "handKey: key=0x" + String.format("%02X", bleCKey));
        sendLocalBroadcast(ACTION_GET_LOCK_KEY);
    }

    private static final String ACTION_LOCK_CLOSE = "com.omni.bleDemo.ACTION_LOCK_CLOSE";

    private void handLockClose(byte[] command) {
        int status = command[5];
        long timestamp = ((command[6] & 0xFF) << 24) | ((command[7] & 0xff) << 16) | ((command[8] & 0xFF) << 8) | (command[9] & 0xFF);
        int runTime = ((command[10] & 0xFF) << 24) | ((command[11] & 0xff) << 16) | ((command[12] & 0xFF) << 8) | (command[13] & 0xFF);


        //        Log.i(TAG, "handLockClose: status=" + status);
        //        Log.i(TAG, "handLockClose: timestamp=" + timestamp);
        //        Log.i(TAG, "handLockClose: runTime=" + runTime);

        Intent intent = new Intent(ACTION_LOCK_CLOSE);
        intent.putExtra("runTime", runTime);
        intent.putExtra("timestamp", timestamp);
        intent.putExtra("status", status);
        sendLocalBroadcast(intent);
    }

    private static final String ACTION_BLE_LOCK_OPEN_STATUS = "com.omni.bleDemo.ACTION_BLE_LOCK_OPEN_STATUS";

    private void handLockOpen(byte[] command) {
        int status = command[5];
        long timestamp = ((command[6] & 0xFF) << 24) | ((command[7] & 0xff) << 16) | ((command[8] & 0xFF) << 8) | (command[9] & 0xFF);
        Intent intent = new Intent(ACTION_BLE_LOCK_OPEN_STATUS);
        intent.putExtra("status", status);
        intent.putExtra("timestamp", timestamp);
        sendLocalBroadcast(intent);
    }

    //广播接收器
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if (ACTION_CONNECT_BLE.equals(intent.getAction())) {

            } else if (ACTION_LOCK_CLOSE.equals(intent.getAction())) {
                handler.sendEmptyMessage(HANDLER_CLOSE);
            } else if (ACTION_GET_LOCK_KEY.equals(intent.getAction())) {//接收蓝牙传回的秘钥
                handler.sendEmptyMessage(HANDLER_GETKEY);
                isGetKey = true;
            } else if (ACTION_DISCONNECT.equals(intent.getAction())) {
                mBtData.clear();
            } else if (ACTION_BLE_LOCK_OPEN_STATUS.equals(intent.getAction())) {//开锁
                //                int status = intent.getIntExtra("status", 0);
                //                long timestamp = intent.getLongExtra("timestamp", 0L);
                //                Log.i(TAG, "onReceive: status=" + status);
                //                Log.i(TAG, "onReceive: timestamp=" + timestamp);
                handler.sendEmptyMessage(HANDLER_OPEN);
            }
        }
    };

    public static final int     HANDLER_GETKEY = 1;
    public static final int     HANDLER_CLOSE  = 2;
    public static final int     HANDLER_OPEN   = 3;
    private             Handler handler        = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case HANDLER_CLOSE:
                    sendLockResp();
                    ToastUtils.showToast(OpenLockActivity.this, "设备已关闭");
                    break;
                case HANDLER_OPEN:
                    sendOpenResponse();
                    break;
                case HANDLER_GETKEY:
                    break;
            }
        }
    };

    private void sendLockResp() {
        int uid = 1;
        byte[] crcOrder = CommandUtil.getCRCLockCommand(bleCKey);
        Log.i(TAG, "sendOpenResponse: 上锁回复=" + getCommForHex(crcOrder));
        mBLEGCWrite.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        mBLEGCWrite.setValue(crcOrder);
        mBLEGatt.writeCharacteristic(mBLEGCWrite);

    }

    public void sendOpenResponse() {
        byte[] crcOrder = CommandUtil.getCRCOpenResCommand(bleCKey);
        Log.i(TAG, "sendOpenResponse: 开锁回复=" + getCommForHex(crcOrder));
        mBLEGCWrite.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
        mBLEGCWrite.setValue(crcOrder);
        mBLEGatt.writeCharacteristic(mBLEGCWrite);
    }

    //获取16进制
    private String getCommForHex(byte[] values) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < values.length; i++) {
            sb.append(String.format("%02X,", values[i]));
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    //    private int REQUEST_ENABLE                  = 400;
    //    private int BLUETOOTH_DISCOVERABLE_DURATION = 120;//Bluetooth 设备可见时间，单位：秒，不设置默认120s。
    //    private void searchBlueDevice() {
    //        //搜索附近蓝牙设备
    //        mBtData.clear();
    //        boolean bluetoothSupported = BluetoothManagerUtils.isBluetoothSupported();
    //        if (bluetoothSupported) {
    //            boolean bluetoothEnabled = BluetoothManagerUtils.isBluetoothEnabled();
    //            if (!bluetoothEnabled) {
    //                //弹出对话框提示用户是否打开
    //                Intent enabler = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
    //                // 设置 Bluetooth 设备可以被其它 Bluetooth 设备扫描到
    //                enabler.setAction(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
    //                // 设置 Bluetooth 设备可见时间
    //                enabler.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, BLUETOOTH_DISCOVERABLE_DURATION);
    //                startActivityForResult(enabler, REQUEST_ENABLE);
    //            } else {
    //                //申请权限
    //                //needLoactionRight();
    //                //开始搜索
    //                startSearchBluetooth();
    //            }
    //        } else {
    //            ToastUtils.showToast(this, "当前设备不支持蓝牙功能");
    //        }
    //    }
}
