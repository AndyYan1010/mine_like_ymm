package com.bt.smart.truck_broker;

/**
 * @创建者 AndyYan
 * @创建时间 2018/8/28 8:48
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class NetConfig {
    //服务器总地址
    //    public static String ROOT             = "http://www.smart-hox.com:8081/hoxJK/";
    public static String ROOT        = "http://205.168.1.118/yingsu_war_exploded/rest/";
    //图片地址
    public static String IMG_HEAD    = "http://www.smart-hox.com:8083/upFiles/";
    public static String IMG_HEAD_IP = "http://112.90.178.68:8081/upFiles/";

    //获取最新版本apk信息
    public static String GETNEWAPPVERSION = ROOT + "getNewAppVersion";

    //base64上传图片
    public static String UPLOADBASE64ANDROID   = ROOT + "uploadBase64Android";
    public static String UPLOADBASE64          = ROOT + "uploadBase64";
    //获取验证码
    public static String CHECKMESSAGE          = ROOT + "tokens/SMScode";
    //注册用户
    public static String USERINSERTPC          = ROOT + "userInsertPC";
    //修改密码(记得原密码)
    public static String BACKFPASSWORD         = ROOT + "backFpassword";
    //修改密码(忘记原密码)
    public static String BACKFPASSWORDBYMOBILE = ROOT + "backFpasswordByMobile";
    //用户登录
    public static String LOGINURL              = ROOT + "tokens/registerdriver";
    //验证码登录
    public static String CodeLOGINURL          = ROOT + "tokens/registerdriver";
    //获取用户信息
    public static String REGISTERINFO          = ROOT + "registerInfo";


}
