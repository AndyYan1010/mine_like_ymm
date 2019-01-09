package com.bt.smart.truck_broker.messageInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/9 16:19
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class AllOrderListInfo {

    /**
     * message : 成功
     * data : [{"id":"2c90b4e3683056b701683059a83b0009","orderGoodsList":[{"id":"2c90b4e3683056b701683059a83c000a","orderId":"2c90b4e3683056b701683059a83b0009","goodsSpace":0,"goodsName":"string","goodsWeight":0}],"carType":"string","fhTelephone":"string","shName":"string","shAddress":"string","fcheck":"string","fhAddress":"string","shArea":"string","fsubId":"yingsu0001002","goodsName":"string","fhName":"string","zhTime":"2019-01-09 10:01:07","isFapiao":"1","fmainId":"yingsu0001","shTelephone":"string","fh":"string","sh":"string","fstatus":"string"}]
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
         * id : 2c90b4e3683056b701683059a83b0009
         * orderGoodsList : [{"id":"2c90b4e3683056b701683059a83c000a","orderId":"2c90b4e3683056b701683059a83b0009","goodsSpace":0,"goodsName":"string","goodsWeight":0}]
         * carType : string
         * fhTelephone : string
         * shName : string
         * shAddress : string
         * fcheck : string
         * fhAddress : string
         * shArea : string
         * fsubId : yingsu0001002
         * goodsName : string
         * fhName : string
         * zhTime : 2019-01-09 10:01:07
         * isFapiao : 1
         * fmainId : yingsu0001
         * shTelephone : string
         * fh : string
         * sh : string
         * fstatus : string
         */

        private String id;
        private String                   carType;
        private String                   fhTelephone;
        private String                   shName;
        private String                   shAddress;
        private String                   fcheck;
        private String                   fhAddress;
        private String                   shArea;
        private String                   fsubId;
        private String                   goodsName;
        private String                   fhName;
        private String                   zhTime;
        private String                   isFapiao;
        private String                   fmainId;
        private String                   shTelephone;
        private String                   fh;
        private String                   sh;
        private String                   fstatus;
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

        public String getShAddress() {
            return shAddress;
        }

        public void setShAddress(String shAddress) {
            this.shAddress = shAddress;
        }

        public String getFcheck() {
            return fcheck;
        }

        public void setFcheck(String fcheck) {
            this.fcheck = fcheck;
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

        public String getFsubId() {
            return fsubId;
        }

        public void setFsubId(String fsubId) {
            this.fsubId = fsubId;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getFhName() {
            return fhName;
        }

        public void setFhName(String fhName) {
            this.fhName = fhName;
        }

        public String getZhTime() {
            return zhTime;
        }

        public void setZhTime(String zhTime) {
            this.zhTime = zhTime;
        }

        public String getIsFapiao() {
            return isFapiao;
        }

        public void setIsFapiao(String isFapiao) {
            this.isFapiao = isFapiao;
        }

        public String getFmainId() {
            return fmainId;
        }

        public void setFmainId(String fmainId) {
            this.fmainId = fmainId;
        }

        public String getShTelephone() {
            return shTelephone;
        }

        public void setShTelephone(String shTelephone) {
            this.shTelephone = shTelephone;
        }

        public String getFh() {
            return fh;
        }

        public void setFh(String fh) {
            this.fh = fh;
        }

        public String getSh() {
            return sh;
        }

        public void setSh(String sh) {
            this.sh = sh;
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
             * id : 2c90b4e3683056b701683059a83c000a
             * orderId : 2c90b4e3683056b701683059a83b0009
             * goodsSpace : 0
             * goodsName : string
             * goodsWeight : 0
             */

            private String id;
            private String orderId;
            private int    goodsSpace;
            private String goodsName;
            private int    goodsWeight;

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

            public int getGoodsSpace() {
                return goodsSpace;
            }

            public void setGoodsSpace(int goodsSpace) {
                this.goodsSpace = goodsSpace;
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
        }
    }
    /*{
  "message": "成功",
  "data": [
    {
      "id": "2c90b4e3683056b701683059a83b0009",
      "carType": "string",
      "fcheck": "string",
      "fhName": "string",
      "fmainId": "yingsu0001",
      "fh": "string",
      "fstatus": "string",
      "shAddress": "string",
      "shArea": "string",
      "shName": "string",
      "fsubId": "yingsu0001002",
      "isFapiao": "1",
      "goodsName": "string",
      "fhAddress": "string",
      "shTelephone": "string",
      "sh": "string",
      "zhTime": "2019-01-09 10:01:07",
      "fhTelephone": "string",
      "orderGoodsList": [
        {
          "id": "2c90b4e3683056b701683059a83c000a",
          "goodsWeight": 0,
          "goodsSpace": 0,
          "goodsName": "string",
          "orderId": "2c90b4e3683056b701683059a83b0009"
        }
      ]
    },
    {
      "id": "4d2881f668112c7b01681138da950001",
      "carType": "大卡车",
      "fcheck": "1",
      "fhName": "张三",
      "fmainId": "1",
      "fh": "*",
      "fstatus": "0",
      "shAddress": "广州",
      "shArea": "广州",
      "shName": "李四",
      "fsubId": "yingsu0001002",
      "isFapiao": "1",
      "goodsName": "床上用品",
      "fhAddress": "海门",
      "shTelephone": "13779806859",
      "sh": "*",
      "zhTime": "2019-01-03 19:03",
      "fhTelephone": "13897604863",
      "orderGoodsList": [
        {
          "id": "4d2881f668112c7b01681138da950002",
          "goodsWeight": 20,
          "goodsSpace": 100,
          "goodsName": null,
          "orderId": "4d2881f668112c7b01681138da950001"
        }
      ]
    }
  ],
  "ok": true,
  "respCode": "0"
}*/
}
