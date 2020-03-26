package com.eju.cy.paylibrary.dto;

public class LaunchPayBean {


    /**
     * msg : 成功
     * data : {"order_des":"无为支付测试","create_time":"2020-03-25 11:17:31","trade_status":1,"id":11,"subject":"支付测试","pay_type":0,"user_id":1,"total_amount":"0.01","no":"5VX407YQ2a2bc0846e4711eab95a00163e0ad880","state":0,"order_batch":"1","modify_time":"2020-03-25 11:17:31"}
     * code : 10000
     * encrypt : 0
     */

    private String msg;
    private DataBean data;
    private String code;
    private int encrypt;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(int encrypt) {
        this.encrypt = encrypt;
    }

    public static class DataBean {
        /**
         * order_des : 无为支付测试
         * create_time : 2020-03-25 11:17:31
         * trade_status : 1
         * id : 11
         * subject : 支付测试
         * pay_type : 0
         * user_id : 1
         * total_amount : 0.01
         * no : 5VX407YQ2a2bc0846e4711eab95a00163e0ad880
         * state : 0
         * order_batch : 1
         * modify_time : 2020-03-25 11:17:31
         */

        private String order_des;
        private String create_time;
        private int trade_status;
        private int id;
        private String subject;
        private int pay_type;
        private int user_id;
        private String total_amount;
        private String no;
        private int state;
        private String order_batch;
        private String modify_time;

        public String getOrder_des() {
            return order_des;
        }

        public void setOrder_des(String order_des) {
            this.order_des = order_des;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public int getTrade_status() {
            return trade_status;
        }

        public void setTrade_status(int trade_status) {
            this.trade_status = trade_status;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public int getPay_type() {
            return pay_type;
        }

        public void setPay_type(int pay_type) {
            this.pay_type = pay_type;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getOrder_batch() {
            return order_batch;
        }

        public void setOrder_batch(String order_batch) {
            this.order_batch = order_batch;
        }

        public String getModify_time() {
            return modify_time;
        }

        public void setModify_time(String modify_time) {
            this.modify_time = modify_time;
        }
    }
}
