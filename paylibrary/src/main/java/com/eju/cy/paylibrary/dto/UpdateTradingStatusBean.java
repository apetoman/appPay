package com.eju.cy.paylibrary.dto;

public class UpdateTradingStatusBean {


    /**
     * msg : 交易状态，付款方式更新成功
     * data : {"no":"5VX407YQ2a2bc0846e4711eab95a00163e0ad880"}
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
         * no : 5VX407YQ2a2bc0846e4711eab95a00163e0ad880
         */

        private String no;

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }
    }
}
