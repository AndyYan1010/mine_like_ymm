package com.bt.smart.truck_broker.messageInfo;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/9 13:32
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class UpDataDriverInfo {

    /**
     * message : 成功
     * data : 更新司机信息表信息成功
     * respCode : 0
     * ok : true
     */

    private String message;
    private String  data;
    private String  respCode;
    private boolean ok;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
