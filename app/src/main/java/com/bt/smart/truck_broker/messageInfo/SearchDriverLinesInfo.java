package com.bt.smart.truck_broker.messageInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/10 11:31
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class SearchDriverLinesInfo {

    /**
     * message : 成功
     * data : [{"id":"4d2881f66835ca5a016836d83018000c","car_long":"2米","car_type":"平板","driver_id":"2c9084dd6831e10501683266018b0003","origin":"港闸区","destination":"崇川区"},{"id":"4d2881f66835ca5a016836d844c3000d","car_long":"2米","car_type":"平板","driver_id":"2c9084dd6831e10501683266018b0003","origin":"海安县","destination":"崇川区"}]
     * respCode : 0
     * ok : true
     */

    private String message;
    private String         respCode;
    private boolean        ok;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4d2881f66835ca5a016836d83018000c
         * car_long : 2米
         * car_type : 平板
         * driver_id : 2c9084dd6831e10501683266018b0003
         * origin : 港闸区
         * destination : 崇川区
         */

        private String id;
        private String car_long;
        private String car_type;
        private String driver_id;
        private String origin;
        private String destination;
        /**
         * canDel : false
         */

        private boolean canDel;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCar_long() {
            return car_long;
        }

        public void setCar_long(String car_long) {
            this.car_long = car_long;
        }

        public String getCar_type() {
            return car_type;
        }

        public void setCar_type(String car_type) {
            this.car_type = car_type;
        }

        public String getDriver_id() {
            return driver_id;
        }

        public void setDriver_id(String driver_id) {
            this.driver_id = driver_id;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public boolean isCanDel() {
            return canDel;
        }

        public void setCanDel(boolean canDel) {
            this.canDel = canDel;
        }
    }
}
