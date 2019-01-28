package com.bt.smart.truck_broker.messageInfo;

import java.util.List;

/**
 * @创建者 AndyYan
 * @创建时间 2019/1/23 10:16
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class ReadyRecOrderInfo {

    /**
     * code : 1
     * size : 1
     * orderList : [{"fh_address":"南通","order_no":"2019012501245971363","origin_province_id":"13","fh":"1447","origin":"安徽省安庆市大观区","destination":"北京市市辖区昌平区","origin_area_id":"1447","fh_name":"赵一","is_appoint":"0","destination_area_id":"390","car_type":"2","ffee":999.34,"destination_province_id":"2","fcheck":"0","fstatus":"1","fweight":34,"sh":"390","is_fapiao":"0","appoint_id":"","id":"2c90b4e36882e87c016883781fb","origin_city_id":"140","destination_city_id":"33","zh_time":{"date":25,"hours":0,"seconds":0,"month":0,"nanos":0,"timezoneOffset":-480,"year":119,"minutes":0,"time":1548345600000,"day":5},"goods_name":"服装","fh_telephone":"18234567890","sh_name":"李四","fsub_id":"","sh_address":"上海","sh_area":"","fmain_id":"yingsu0028","sh_telephone":"18234567898"}]
     * message : 订单列表获取成功
     */

    private int code;
    private int                 size;
    private String              message;
    private List<OrderListBean> orderList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<OrderListBean> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<OrderListBean> orderList) {
        this.orderList = orderList;
    }

    public static class OrderListBean {
        /**
         * fh_address : 南通
         * order_no : 2019012501245971363
         * origin_province_id : 13
         * fh : 1447
         * origin : 安徽省安庆市大观区
         * destination : 北京市市辖区昌平区
         * origin_area_id : 1447
         * fh_name : 赵一
         * is_appoint : 0
         * destination_area_id : 390
         * car_type : 2
         * ffee : 999.34
         * destination_province_id : 2
         * fcheck : 0
         * fstatus : 1
         * fweight : 34
         * sh : 390
         * is_fapiao : 0
         * appoint_id :
         * id : 2c90b4e36882e87c016883781fb
         * origin_city_id : 140
         * destination_city_id : 33
         * zh_time : {"date":25,"hours":0,"seconds":0,"month":0,"nanos":0,"timezoneOffset":-480,"year":119,"minutes":0,"time":1548345600000,"day":5}
         * goods_name : 服装
         * fh_telephone : 18234567890
         * sh_name : 李四
         * fsub_id :
         * sh_address : 上海
         * sh_area :
         * fmain_id : yingsu0028
         * sh_telephone : 18234567898
         */

        private String fh_address;
        private String     order_no;
        private String     origin_province_id;
        private String     fh;
        private String     origin;
        private String     destination;
        private String     origin_area_id;
        private String     fh_name;
        private String     is_appoint;
        private String     destination_area_id;
        private String     car_type;
        private double     ffee;
        private String     destination_province_id;
        private String     fcheck;
        private String     fstatus;
        private int        fweight;
        private String     sh;
        private String     is_fapiao;
        private String     appoint_id;
        private String     id;
        private String     origin_city_id;
        private String     destination_city_id;
        private ZhTimeBean zh_time;
        private String     goods_name;
        private String     fh_telephone;
        private String     sh_name;
        private String     fsub_id;
        private String     sh_address;
        private String     sh_area;
        private String     fmain_id;
        private String     sh_telephone;

        public String getFh_address() {
            return fh_address;
        }

        public void setFh_address(String fh_address) {
            this.fh_address = fh_address;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getOrigin_province_id() {
            return origin_province_id;
        }

        public void setOrigin_province_id(String origin_province_id) {
            this.origin_province_id = origin_province_id;
        }

        public String getFh() {
            return fh;
        }

        public void setFh(String fh) {
            this.fh = fh;
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

        public String getOrigin_area_id() {
            return origin_area_id;
        }

        public void setOrigin_area_id(String origin_area_id) {
            this.origin_area_id = origin_area_id;
        }

        public String getFh_name() {
            return fh_name;
        }

        public void setFh_name(String fh_name) {
            this.fh_name = fh_name;
        }

        public String getIs_appoint() {
            return is_appoint;
        }

        public void setIs_appoint(String is_appoint) {
            this.is_appoint = is_appoint;
        }

        public String getDestination_area_id() {
            return destination_area_id;
        }

        public void setDestination_area_id(String destination_area_id) {
            this.destination_area_id = destination_area_id;
        }

        public String getCar_type() {
            return car_type;
        }

        public void setCar_type(String car_type) {
            this.car_type = car_type;
        }

        public double getFfee() {
            return ffee;
        }

        public void setFfee(double ffee) {
            this.ffee = ffee;
        }

        public String getDestination_province_id() {
            return destination_province_id;
        }

        public void setDestination_province_id(String destination_province_id) {
            this.destination_province_id = destination_province_id;
        }

        public String getFcheck() {
            return fcheck;
        }

        public void setFcheck(String fcheck) {
            this.fcheck = fcheck;
        }

        public String getFstatus() {
            return fstatus;
        }

        public void setFstatus(String fstatus) {
            this.fstatus = fstatus;
        }

        public int getFweight() {
            return fweight;
        }

        public void setFweight(int fweight) {
            this.fweight = fweight;
        }

        public String getSh() {
            return sh;
        }

        public void setSh(String sh) {
            this.sh = sh;
        }

        public String getIs_fapiao() {
            return is_fapiao;
        }

        public void setIs_fapiao(String is_fapiao) {
            this.is_fapiao = is_fapiao;
        }

        public String getAppoint_id() {
            return appoint_id;
        }

        public void setAppoint_id(String appoint_id) {
            this.appoint_id = appoint_id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getOrigin_city_id() {
            return origin_city_id;
        }

        public void setOrigin_city_id(String origin_city_id) {
            this.origin_city_id = origin_city_id;
        }

        public String getDestination_city_id() {
            return destination_city_id;
        }

        public void setDestination_city_id(String destination_city_id) {
            this.destination_city_id = destination_city_id;
        }

        public ZhTimeBean getZh_time() {
            return zh_time;
        }

        public void setZh_time(ZhTimeBean zh_time) {
            this.zh_time = zh_time;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getFh_telephone() {
            return fh_telephone;
        }

        public void setFh_telephone(String fh_telephone) {
            this.fh_telephone = fh_telephone;
        }

        public String getSh_name() {
            return sh_name;
        }

        public void setSh_name(String sh_name) {
            this.sh_name = sh_name;
        }

        public String getFsub_id() {
            return fsub_id;
        }

        public void setFsub_id(String fsub_id) {
            this.fsub_id = fsub_id;
        }

        public String getSh_address() {
            return sh_address;
        }

        public void setSh_address(String sh_address) {
            this.sh_address = sh_address;
        }

        public String getSh_area() {
            return sh_area;
        }

        public void setSh_area(String sh_area) {
            this.sh_area = sh_area;
        }

        public String getFmain_id() {
            return fmain_id;
        }

        public void setFmain_id(String fmain_id) {
            this.fmain_id = fmain_id;
        }

        public String getSh_telephone() {
            return sh_telephone;
        }

        public void setSh_telephone(String sh_telephone) {
            this.sh_telephone = sh_telephone;
        }

        public static class ZhTimeBean {
            /**
             * date : 25
             * hours : 0
             * seconds : 0
             * month : 0
             * nanos : 0
             * timezoneOffset : -480
             * year : 119
             * minutes : 0
             * time : 1548345600000
             * day : 5
             */

            private int date;
            private int  hours;
            private int  seconds;
            private int  month;
            private int  nanos;
            private int  timezoneOffset;
            private int  year;
            private int  minutes;
            private long time;
            private int  day;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getNanos() {
                return nanos;
            }

            public void setNanos(int nanos) {
                this.nanos = nanos;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }
        }
    }
}
