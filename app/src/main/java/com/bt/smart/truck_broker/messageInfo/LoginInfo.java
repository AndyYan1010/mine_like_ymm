package com.bt.smart.truck_broker.messageInfo;

/**
 * @创建者 AndyYan
 * @创建时间 2018/8/28 8:58
 * @描述 ${TODO}
 * @更新者 $Author$
 * @更新时间 $Date$
 * @更新描述 ${TODO}
 */

public class LoginInfo {

    /**
     * registerDriver : {"fid":"","faccountEncryption":"","fname":"","fphoto":"","companyName":"","checkReason":"","faccount":0,"fpassword":"e10adc3949ba59abbe56e057f20f883e","idNumber":"","fmobile":"18036215618","fpoints":0,"checkStatus":"","drivingLicense":"","idCard1":"","idCard2":"","driverLicense":"","id":"4d2881f66826449b016826502c9c0003"}
     * token : eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxODAzNjIxNTYxOCIsInN1YiI6IjE4MDM2MjE1NjE4IiwiaWF0IjoxNTQ2ODQzOTk5fQ.j5nIqA70w2sEyRknmcuZkRGw-O-ECZc4lRbI3koyXY4
     */

    private RegisterDriverBean registerDriver;
    private String token;

    public RegisterDriverBean getRegisterDriver() {
        return registerDriver;
    }

    public void setRegisterDriver(RegisterDriverBean registerDriver) {
        this.registerDriver = registerDriver;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class RegisterDriverBean {
        /**
         * fid :
         * faccountEncryption :
         * fname :
         * fphoto :
         * companyName :
         * checkReason :
         * faccount : 0.0
         * fpassword : e10adc3949ba59abbe56e057f20f883e
         * idNumber :
         * fmobile : 18036215618
         * fpoints : 0
         * checkStatus :
         * drivingLicense :
         * idCard1 :
         * idCard2 :
         * driverLicense :
         * id : 4d2881f66826449b016826502c9c0003
         */

        private String fid;
        private String faccountEncryption;
        private String fname;
        private String fphoto;
        private String companyName;
        private String checkReason;
        private double faccount;
        private String fpassword;
        private String idNumber;
        private String fmobile;
        private int    fpoints;
        private String checkStatus;
        private String drivingLicense;
        private String idCard1;
        private String idCard2;
        private String driverLicense;
        private String id;

        public String getFid() {
            return fid;
        }

        public void setFid(String fid) {
            this.fid = fid;
        }

        public String getFaccountEncryption() {
            return faccountEncryption;
        }

        public void setFaccountEncryption(String faccountEncryption) {
            this.faccountEncryption = faccountEncryption;
        }

        public String getFname() {
            return fname;
        }

        public void setFname(String fname) {
            this.fname = fname;
        }

        public String getFphoto() {
            return fphoto;
        }

        public void setFphoto(String fphoto) {
            this.fphoto = fphoto;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCheckReason() {
            return checkReason;
        }

        public void setCheckReason(String checkReason) {
            this.checkReason = checkReason;
        }

        public double getFaccount() {
            return faccount;
        }

        public void setFaccount(double faccount) {
            this.faccount = faccount;
        }

        public String getFpassword() {
            return fpassword;
        }

        public void setFpassword(String fpassword) {
            this.fpassword = fpassword;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getFmobile() {
            return fmobile;
        }

        public void setFmobile(String fmobile) {
            this.fmobile = fmobile;
        }

        public int getFpoints() {
            return fpoints;
        }

        public void setFpoints(int fpoints) {
            this.fpoints = fpoints;
        }

        public String getCheckStatus() {
            return checkStatus;
        }

        public void setCheckStatus(String checkStatus) {
            this.checkStatus = checkStatus;
        }

        public String getDrivingLicense() {
            return drivingLicense;
        }

        public void setDrivingLicense(String drivingLicense) {
            this.drivingLicense = drivingLicense;
        }

        public String getIdCard1() {
            return idCard1;
        }

        public void setIdCard1(String idCard1) {
            this.idCard1 = idCard1;
        }

        public String getIdCard2() {
            return idCard2;
        }

        public void setIdCard2(String idCard2) {
            this.idCard2 = idCard2;
        }

        public String getDriverLicense() {
            return driverLicense;
        }

        public void setDriverLicense(String driverLicense) {
            this.driverLicense = driverLicense;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
