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
     * data : {"id":"2c90b4e36835d2d501683643e62d0009","carType":"货车","zhTime":"2019-01-10","fmainId":"","fcheck":"0","goodsName":"货物类别服装","fhAddress":"发货人地址南通","shArea":"收货人地区上海","shTelephone":"18234567898","shAddress":"收货人地址上海","fstatus":"0","fsubId":"","fhName":"发货人张三","sh":"1235","fhTelephone":"18234567890","shName":"收货人李四","fh":"1236","isFapiao":"0","orderGoodsList":[{"id":"2c90b4e36835d2d501683643e62e000a","orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"上装","goodsWeight":12,"goodsSpace":11},{"id":"2c90b4e36835d2d501683643e62e000b","orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"下装","goodsWeight":22,"goodsSpace":21}]}
     * respCode : 0
     * ok : true
     */

    private String message;
    private DataBean data;
    private String   respCode;
    private boolean  ok;

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

    public static class DataBean {
        /**
         * id : 2c90b4e36835d2d501683643e62d0009
         * carType : 货车
         * zhTime : 2019-01-10
         * fmainId :
         * fcheck : 0
         * goodsName : 货物类别服装
         * fhAddress : 发货人地址南通
         * shArea : 收货人地区上海
         * shTelephone : 18234567898
         * shAddress : 收货人地址上海
         * fstatus : 0
         * fsubId :
         * fhName : 发货人张三
         * sh : 1235
         * fhTelephone : 18234567890
         * shName : 收货人李四
         * fh : 1236
         * isFapiao : 0
         * orderGoodsList : [{"id":"2c90b4e36835d2d501683643e62e000a","orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"上装","goodsWeight":12,"goodsSpace":11},{"id":"2c90b4e36835d2d501683643e62e000b","orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"下装","goodsWeight":22,"goodsSpace":21}]
         */

        private String id;
        private String                   carType;
        private String                   zhTime;
        private String                   fmainId;
        private String                   fcheck;
        private String                   goodsName;
        private String                   fhAddress;
        private String                   shArea;
        private String                   shTelephone;
        private String                   shAddress;
        private String                   fstatus;
        private String                   fsubId;
        private String                   fhName;
        private String                   sh;
        private String                   fhTelephone;
        private String                   shName;
        private String                   fh;
        private String                   isFapiao;
        private List<OrderGoodsListBean> orderGoodsList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCarType() {
            return carType;
        }

        public void setCarType(String carType) {
            this.carType = carType;
        }

        public String getZhTime() {
            return zhTime;
        }

        public void setZhTime(String zhTime) {
            this.zhTime = zhTime;
        }

        public String getFmainId() {
            return fmainId;
        }

        public void setFmainId(String fmainId) {
            this.fmainId = fmainId;
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

        public String getFhAddress() {
            return fhAddress;
        }

        public void setFhAddress(String fhAddress) {
            this.fhAddress = fhAddress;
        }

        public String getShArea() {
            return shArea;
        }

        public void setShArea(String shArea) {
            this.shArea = shArea;
        }

        public String getShTelephone() {
            return shTelephone;
        }

        public void setShTelephone(String shTelephone) {
            this.shTelephone = shTelephone;
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

        public String getFsubId() {
            return fsubId;
        }

        public void setFsubId(String fsubId) {
            this.fsubId = fsubId;
        }

        public String getFhName() {
            return fhName;
        }

        public void setFhName(String fhName) {
            this.fhName = fhName;
        }

        public String getSh() {
            return sh;
        }

        public void setSh(String sh) {
            this.sh = sh;
        }

        public String getFhTelephone() {
            return fhTelephone;
        }

        public void setFhTelephone(String fhTelephone) {
            this.fhTelephone = fhTelephone;
        }

        public String getShName() {
            return shName;
        }

        public void setShName(String shName) {
            this.shName = shName;
        }

        public String getFh() {
            return fh;
        }

        public void setFh(String fh) {
            this.fh = fh;
        }

        public String getIsFapiao() {
            return isFapiao;
        }

        public void setIsFapiao(String isFapiao) {
            this.isFapiao = isFapiao;
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
             * orderId : 2c90b4e36835d2d501683643e62d0009
             * goodsName : 上装
             * goodsWeight : 12
             * goodsSpace : 11
             */

            private String id;
            private String orderId;
            private String goodsName;
            private int    goodsWeight;
            private int    goodsSpace;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public int getGoodsWeight() {
                return goodsWeight;
            }

            public void setGoodsWeight(int goodsWeight) {
                this.goodsWeight = goodsWeight;
            }

            public int getGoodsSpace() {
                return goodsSpace;
            }

            public void setGoodsSpace(int goodsSpace) {
                this.goodsSpace = goodsSpace;
            }
        }
    }
}
