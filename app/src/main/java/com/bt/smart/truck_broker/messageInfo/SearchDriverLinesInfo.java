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
     * data : [{"id":"4d2881f66835ca5a0168363ad0d00001","origin":"苏州","destination":"南通","driverId":"2c9084dd6831e10501683266018b0003","carType":"平板","carLong":"2米"},{"id":"4d2881f66835ca5a0168367a1c220002","origin":"382","destination":"390","driverId":"2c9084dd6831e10501683266018b0003","carType":"平板","carLong":"2米"}]
     * ok : true
     * respCode : 0
     */

    private String message;
    private boolean        ok;
    private String         respCode;
    private List<DataBean> data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4d2881f66835ca5a0168363ad0d00001
         * origin : 苏州
         * destination : 南通
         * driverId : 2c9084dd6831e10501683266018b0003
         * carType : 平板
         * carLong : 2米
         */

        private String id;
        private String origin;
        private String destination;
        private String driverId;
        private String carType;
        private String carLong;
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

        public String getDriverId() {
            return driverId;
        }

        public void setDriverId(String driverId) {
            this.driverId = driverId;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getCarLong() {
            return carLong;
        }

        public void setCarLong(String carLong) {
            this.carLong = carLong;
        }

        public boolean isCanDel() {
            return canDel;
        }

        public void setCanDel(boolean canDel) {
            this.canDel = canDel;
        }
    }
}
