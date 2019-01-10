package com.bt.smart.truck_broker.messageInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/9 18:53
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class OrderDetailInfo {

    /**
     * message : 成功
     * data : {"id":"2c90b4e36835d2d501683643e62d0009","fhTelephone":"18234567890","shTelephone":"18234567898","orderGoodsList":[{"id":"2c90b4e36835d2d501683643e62e000a","goodsWeight":12,"orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"上装","goodsSpace":11},{"id":"2c90b4e36835d2d501683643e62e000b","goodsWeight":22,"orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"下装","goodsSpace":21}],"carType":"货车","sh":"1235","fhName":"发货人张三","shArea":"收货人地区上海","zhTime":"2019-01-10","fhAddress":"发货人地址南通","fcheck":"0","goodsName":"货物类别服装","fmainId":"","fsubId":"","isFapiao":"0","fh":"1236","shName":"收货人李四","shAddress":"收货人地址上海","fstatus":"0"}
     * ok : true
     * respCode : 0
     */

    private String message;
    private DataBean data;
    private boolean  ok;
    private String   respCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
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

    public static class DataBean {
        /**
         * id : 2c90b4e36835d2d501683643e62d0009
         * fhTelephone : 18234567890
         * shTelephone : 18234567898
         * orderGoodsList : [{"id":"2c90b4e36835d2d501683643e62e000a","goodsWeight":12,"orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"上装","goodsSpace":11},{"id":"2c90b4e36835d2d501683643e62e000b","goodsWeight":22,"orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"下装","goodsSpace":21}]
         * carType : 货车
         * sh : 1235
         * fhName : 发货人张三
         * shArea : 收货人地区上海
         * zhTime : 2019-01-10
         * fhAddress : 发货人地址南通
         * fcheck : 0
         * goodsName : 货物类别服装
         * fmainId :
         * fsubId :
         * isFapiao : 0
         * fh : 1236
         * shName : 收货人李四
         * shAddress : 收货人地址上海
         * fstatus : 0
         */

        private String id;
        private String                   fhTelephone;
        private String                   shTelephone;
        private String                   carType;
        private String                   sh;
        private String                   fhName;
        private String                   shArea;
        private String                   zhTime;
        private String                   fhAddress;
        private String                   fcheck;
        private String                   goodsName;
        private String                   fmainId;
        private String                   fsubId;
        private String                   isFapiao;
        private String                   fh;
        private String                   shName;
        private String                   shAddress;
        private String                   fstatus;
        private List<OrderGoodsListBean> orderGoodsList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFhTelephone() {
            return fhTelephone;
        }

        public void setFhTelephone(String fhTelephone) {
            this.fhTelephone = fhTelephone;
        }

        public String getShTelephone() {
            return shTelephone;
        }

        public void setShTelephone(String shTelephone) {
            this.shTelephone = shTelephone;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getSh() {
            return sh;
        }

        public void setSh(String sh) {
            this.sh = sh;
        }

        public String getFhName() {
            return fhName;
        }

        public void setFhName(String fhName) {
            this.fhName = fhName;
        }

        public String getShArea() {
            return shArea;
        }

        public void setShArea(String shArea) {
            this.shArea = shArea;
        }

        public String getZhTime() {
            return zhTime;
        }

        public void setZhTime(String zhTime) {
            this.zhTime = zhTime;
        }

        public String getFhAddress() {
            return fhAddress;
        }

        public void setFhAddress(String fhAddress) {
            this.fhAddress = fhAddress;
        }

        public String getFcheck() {
            return fcheck;
        }

        public void setFcheck(String fcheck) {
            this.fcheck = fcheck;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getFmainId() {
            return fmainId;
        }

        public void setFmainId(String fmainId) {
            this.fmainId = fmainId;
        }

        public String getFsubId() {
            return fsubId;
        }

        public void setFsubId(String fsubId) {
            this.fsubId = fsubId;
        }

        public String getIsFapiao() {
            return isFapiao;
        }

        public void setIsFapiao(String isFapiao) {
            this.isFapiao = isFapiao;
        }

        public String getFh() {
            return fh;
        }

        public void setFh(String fh) {
            this.fh = fh;
        }

        public String getShName() {
            return shName;
        }

        public void setShName(String shName) {
            this.shName = shName;
        }

        public String getShAddress() {
            return shAddress;
        }

        public void setShAddress(String shAddress) {
            this.shAddress = shAddress;
        }

        public String getFstatus() {
            return fstatus;
        }

        public void setFstatus(String fstatus) {
            this.fstatus = fstatus;
        }

        public List<OrderGoodsListBean> getOrderGoodsList() {
            return orderGoodsList;
        }

        public void setOrderGoodsList(List<OrderGoodsListBean> orderGoodsList) {
            this.orderGoodsList = orderGoodsList;
        }

        public static class OrderGoodsListBean {
            /**
             * id : 2c90b4e36835d2d501683643e62e000a
             * goodsWeight : 12.0
             * orderId : 2c90b4e36835d2d501683643e62d0009
             * goodsName : 上装
             * goodsSpace : 11.0
             */

            private String id;
            private double goodsWeight;
            private String orderId;
            private String goodsName;
            private double goodsSpace;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public double getGoodsWeight() {
                return goodsWeight;
            }

            public void setGoodsWeight(double goodsWeight) {
                this.goodsWeight = goodsWeight;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public String getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(String goodsName) {
                this.goodsName = goodsName;
            }

            public double getGoodsSpace() {
                return goodsSpace;
            }

            public void setGoodsSpace(double goodsSpace) {
                this.goodsSpace = goodsSpace;
            }
        }
    }
}
