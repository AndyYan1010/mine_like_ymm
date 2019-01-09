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
     * data : {"id":"4d2881f668112c7b01681138da950001","carType":"大卡车","fcheck":"1","fhName":"张三","fmainId":"1","fh":"*","fstatus":"0","shAddress":"广州","shArea":"广州","shName":"李四","fsubId":"yingsu0001002","isFapiao":"1","goodsName":"床上用品","fhAddress":"海门","shTelephone":"13779806859","sh":"*","zhTime":"2019-01-03 19:03","fhTelephone":"13897604863","orderGoodsList":[{"id":"4d2881f668112c7b01681138da950002","goodsWeight":20,"goodsSpace":100,"goodsName":null,"orderId":"4d2881f668112c7b01681138da950001"}]}
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
         * id : 4d2881f668112c7b01681138da950001
         * carType : 大卡车
         * fcheck : 1
         * fhName : 张三
         * fmainId : 1
         * fh : *
         * fstatus : 0
         * shAddress : 广州
         * shArea : 广州
         * shName : 李四
         * fsubId : yingsu0001002
         * isFapiao : 1
         * goodsName : 床上用品
         * fhAddress : 海门
         * shTelephone : 13779806859
         * sh : *
         * zhTime : 2019-01-03 19:03
         * fhTelephone : 13897604863
         * orderGoodsList : [{"id":"4d2881f668112c7b01681138da950002","goodsWeight":20,"goodsSpace":100,"goodsName":null,"orderId":"4d2881f668112c7b01681138da950001"}]
         */

        private String id;
        private String                   carType;
        private String                   fcheck;
        private String                   fhName;
        private String                   fmainId;
        private String                   fh;
        private String                   fstatus;
        private String                   shAddress;
        private String                   shArea;
        private String                   shName;
        private String                   fsubId;
        private String                   isFapiao;
        private String                   goodsName;
        private String                   fhAddress;
        private String                   shTelephone;
        private String                   sh;
        private String                   zhTime;
        private String                   fhTelephone;
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

        public String getFcheck() {
            return fcheck;
        }

        public void setFcheck(String fcheck) {
            this.fcheck = fcheck;
        }

        public String getFhName() {
            return fhName;
        }

        public void setFhName(String fhName) {
            this.fhName = fhName;
        }

        public String getFmainId() {
            return fmainId;
        }

        public void setFmainId(String fmainId) {
            this.fmainId = fmainId;
        }

        public String getFh() {
            return fh;
        }

        public void setFh(String fh) {
            this.fh = fh;
        }

        public String getFstatus() {
            return fstatus;
        }

        public void setFstatus(String fstatus) {
            this.fstatus = fstatus;
        }

        public String getShAddress() {
            return shAddress;
        }

        public void setShAddress(String shAddress) {
            this.shAddress = shAddress;
        }

        public String getShArea() {
            return shArea;
        }

        public void setShArea(String shArea) {
            this.shArea = shArea;
        }

        public String getShName() {
            return shName;
        }

        public void setShName(String shName) {
            this.shName = shName;
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

        public String getShTelephone() {
            return shTelephone;
        }

        public void setShTelephone(String shTelephone) {
            this.shTelephone = shTelephone;
        }

        public String getSh() {
            return sh;
        }

        public void setSh(String sh) {
            this.sh = sh;
        }

        public String getZhTime() {
            return zhTime;
        }

        public void setZhTime(String zhTime) {
            this.zhTime = zhTime;
        }

        public String getFhTelephone() {
            return fhTelephone;
        }

        public void setFhTelephone(String fhTelephone) {
            this.fhTelephone = fhTelephone;
        }

        public List<OrderGoodsListBean> getOrderGoodsList() {
            return orderGoodsList;
        }

        public void setOrderGoodsList(List<OrderGoodsListBean> orderGoodsList) {
            this.orderGoodsList = orderGoodsList;
        }

        public static class OrderGoodsListBean {
            /**
             * id : 4d2881f668112c7b01681138da950002
             * goodsWeight : 20
             * goodsSpace : 100
             * goodsName : null
             * orderId : 4d2881f668112c7b01681138da950001
             */

            private String id;
            private int    goodsWeight;
            private int    goodsSpace;
            private Object goodsName;
            private String orderId;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public Object getGoodsName() {
                return goodsName;
            }

            public void setGoodsName(Object goodsName) {
                this.goodsName = goodsName;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }
        }
    }
}
