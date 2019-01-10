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
     * data : [{"id":"2c90b4e3683056b701683059a83b0009","fhTelephone":"string","shTelephone":"string","orderGoodsList":[],"carType":"string","sh":"string","fhName":"string","shArea":"string","zhTime":"2019-01-10 13:03:30","fhAddress":"string","fcheck":"string","goodsName":"string","fmainId":"string","fsubId":"string","isFapiao":"1","fh":"string","shName":"string","shAddress":"string","fstatus":"5"},{"id":"2c90b4e36835d2d50168363d0e810002","fhTelephone":"18734567890","shTelephone":"18234567898","orderGoodsList":[{"id":"2c90b4e36835d2d50168363d0e820003","goodsWeight":12,"orderId":"2c90b4e36835d2d50168363d0e810002","goodsName":"上装","goodsSpace":11},{"id":"2c90b4e36835d2d50168363d0e830004","goodsWeight":22,"orderId":"2c90b4e36835d2d50168363d0e810002","goodsName":"下装","goodsSpace":21}],"carType":"货车","sh":"shid","fhName":"张三","shArea":"上海","zhTime":"2019-01-10","fhAddress":"南通","fcheck":"0","goodsName":"服装","fmainId":"","fsubId":"","isFapiao":"0","fh":"fhid","shName":"李四","shAddress":"上海","fstatus":"0"},{"id":"2c90b4e36835d2d501683641c5e40006","fhTelephone":"18234567890","shTelephone":"18234567898","orderGoodsList":[{"id":"2c90b4e36835d2d501683641c5e40007","goodsWeight":12,"orderId":"2c90b4e36835d2d501683641c5e40006","goodsName":"被芯","goodsSpace":11},{"id":"2c90b4e36835d2d501683641c5e50008","goodsWeight":22,"orderId":"2c90b4e36835d2d501683641c5e40006","goodsName":"床单","goodsSpace":21}],"carType":"货车","sh":"shid","fhName":"发货人张三","shArea":"收货人地区上海","zhTime":"2019-01-11","fhAddress":"发货人地址南通","fcheck":"0","goodsName":"床上用品","fmainId":"","fsubId":"","isFapiao":"0","fh":"fhid","shName":"收货人李四","shAddress":"收货人地址上海","fstatus":"0"},{"id":"2c90b4e36835d2d501683643e62d0009","fhTelephone":"18234567890","shTelephone":"18234567898","orderGoodsList":[{"id":"2c90b4e36835d2d501683643e62e000a","goodsWeight":12,"orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"上装","goodsSpace":11},{"id":"2c90b4e36835d2d501683643e62e000b","goodsWeight":22,"orderId":"2c90b4e36835d2d501683643e62d0009","goodsName":"下装","goodsSpace":21}],"carType":"货车","sh":"1235","fhName":"发货人张三","shArea":"收货人地区上海","zhTime":"2019-01-10","fhAddress":"发货人地址南通","fcheck":"0","goodsName":"货物类别服装","fmainId":"","fsubId":"","isFapiao":"0","fh":"1236","shName":"收货人李四","shAddress":"收货人地址上海","fstatus":"0"},{"id":"2c90b4e3683644c0016836458c1a0000","fhTelephone":"18234567890","shTelephone":"18234567898","orderGoodsList":[{"id":"2c90b4e3683644c0016836458c2f0001","goodsWeight":12,"orderId":"2c90b4e3683644c0016836458c1a0000","goodsName":"上装","goodsSpace":11},{"id":"2c90b4e3683644c0016836458c2f0002","goodsWeight":22,"orderId":"2c90b4e3683644c0016836458c1a0000","goodsName":"下装","goodsSpace":21}],"carType":"货车","sh":"1235","fhName":"张三","shArea":"上海","zhTime":"2019-01-10 08:00","fhAddress":"南通","fcheck":"0","goodsName":"服装","fmainId":"yingsu0028","fsubId":"","isFapiao":"0","fh":"1236","shName":"李四","shAddress":"上海","fstatus":"0"},{"id":"2c90b4e368368c940168369130130000","fhTelephone":"18234567890","shTelephone":"18234567898","orderGoodsList":[{"id":"2c90b4e368368c940168369130190001","goodsWeight":12,"orderId":"2c90b4e368368c940168369130130000","goodsName":"上装","goodsSpace":11},{"id":"2c90b4e368368c940168369130190002","goodsWeight":22,"orderId":"2c90b4e368368c940168369130130000","goodsName":"下装","goodsSpace":21}],"carType":"货车","sh":"1235","fhName":"赵六","shArea":"云南","zhTime":"2019-01-11","fhAddress":"南通","fcheck":"0","goodsName":"货物类别服装","fmainId":"yingsu0028","fsubId":"","isFapiao":"1","fh":"1236","shName":"李四","shAddress":"云南","fstatus":"0"},{"id":"2c90b4e368368c94016836a7ef26000a","fhTelephone":"18234567890","shTelephone":"18234567898","orderGoodsList":[{"id":"2c90b4e368368c94016836a7ef28000b","goodsWeight":12,"orderId":"2c90b4e368368c94016836a7ef26000a","goodsName":"上装","goodsSpace":11},{"id":"2c90b4e368368c94016836a7ef29000c","goodsWeight":22,"orderId":"2c90b4e368368c94016836a7ef26000a","goodsName":"下装","goodsSpace":21}],"carType":"货车","sh":"1235","fhName":"发货人张三","shArea":"收货人地区上海","zhTime":"2019-01-12","fhAddress":"发货人地址南通","fcheck":"0","goodsName":"货物类别服装","fmainId":"yingsu0028","fsubId":"","isFapiao":"0","fh":"1236","shName":"收货人李四","shAddress":"收货人地址上海","fstatus":"0"},{"id":"2c90b4e36836b0ef016836b520b10001","fhTelephone":"18234567890","shTelephone":"18234567898","orderGoodsList":[{"id":"2c90b4e36836b0ef016836b520b20002","goodsWeight":12,"orderId":"2c90b4e36836b0ef016836b520b10001","goodsName":"上装","goodsSpace":11},{"id":"2c90b4e36836b0ef016836b520b20003","goodsWeight":22,"orderId":"2c90b4e36836b0ef016836b520b10001","goodsName":"下装","goodsSpace":21}],"carType":"货车","sh":"1235","fhName":"发货人张三","shArea":"收货人地区上海","zhTime":"2019-01-10","fhAddress":"发货人地址南通","fcheck":"0","goodsName":"货物类别服装","fmainId":"","fsubId":"yingsu0028001","isFapiao":"0","fh":"1236","shName":"收货人李四","shAddress":"收货人地址上海","fstatus":"5"},{"id":"2c90b4e36836b0ef016836b544040004","fhTelephone":"18234567890","shTelephone":"18234567898","orderGoodsList":[{"id":"2c90b4e36836b0ef016836b544050005","goodsWeight":12,"orderId":"2c90b4e36836b0ef016836b544040004","goodsName":"上装","goodsSpace":11},{"id":"2c90b4e36836b0ef016836b544050006","goodsWeight":22,"orderId":"2c90b4e36836b0ef016836b544040004","goodsName":"下装","goodsSpace":21}],"carType":"货车","sh":"1235","fhName":"发货人张三","shArea":"收货人地区上海","zhTime":"2019-01-11","fhAddress":"发货人地址南通","fcheck":"0","goodsName":"货物类别服装","fmainId":"","fsubId":"yingsu0028001","isFapiao":"1","fh":"1236","shName":"收货人李四","shAddress":"收货人地址上海","fstatus":"0"},{"id":"4d2881f668112c7b01681138da950001","fhTelephone":"13897604863","shTelephone":"13779806859","orderGoodsList":[{"id":"4d2881f668112c7b01681138da950002","goodsWeight":20,"orderId":"4d2881f668112c7b01681138da950001","goodsName":null,"goodsSpace":100}],"carType":"大卡车","sh":"*","fhName":"张三","shArea":"广州","zhTime":"2019-01-03 19:03","fhAddress":"海门","fcheck":"1","goodsName":"床上用品","fmainId":"1","fsubId":"yingsu0001002","isFapiao":"1","fh":"*","shName":"李四","shAddress":"广州","fstatus":"0"}]
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
         * fhTelephone : string
         * shTelephone : string
         * orderGoodsList : []
         * carType : string
         * sh : string
         * fhName : string
         * shArea : string
         * zhTime : 2019-01-10 13:03:30
         * fhAddress : string
         * fcheck : string
         * goodsName : string
         * fmainId : string
         * fsubId : string
         * isFapiao : 1
         * fh : string
         * shName : string
         * shAddress : string
         * fstatus : 5
         */

        private String id;
        private String  fhTelephone;
        private String  shTelephone;
        private String  carType;
        private String  sh;
        private String  fhName;
        private String  shArea;
        private String  zhTime;
        private String  fhAddress;
        private String  fcheck;
        private String  goodsName;
        private String  fmainId;
        private String  fsubId;
        private String  isFapiao;
        private String  fh;
        private String  shName;
        private String  shAddress;
        private String  fstatus;
        private List<?> orderGoodsList;

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

        public List<?> getOrderGoodsList() {
            return orderGoodsList;
        }

        public void setOrderGoodsList(List<?> orderGoodsList) {
            this.orderGoodsList = orderGoodsList;
        }
    }
}
