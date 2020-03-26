package com.eju.cy.paylibrary.dto;

public class ZhiFuBaoSigBean {


    /**
     * msg : 成功
     * data : {"response":"format=json&timestamp=2020-03-25+11%3A11%3A31&charset=utf-8&app_id=2021001139664395&biz_content=%7B%22body%22%3A%22%E6%97%A0%E4%B8%BA%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95%22%2C%22merchant_order_no%22%3A%2276fa6d9411eaa0e5000c29c3a8b3%22%2C%22out_trade_no%22%3A%22W6IP0ANQ6056af0a6db811eaa8e900163e0ad880%22%2C%22subject%22%3A%22%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95%22%2C%22timeout_express%22%3A%2260m%22%2C%22total_amount%22%3A%220.01%22%7D&sign=aYrkMIgdH3ZzFEVCfg7KM%2BwPeVD1P%2B2TaxHkBjEjqkETQwcFP2%2B71qDY%2FK2Qptz9I1pUQZ7vY1ffgsayY7PnL33u3xCJAARE9V7k3V1hJAbgteu0OmbQW1m1%2Fx1IcrrmUkWVlEPAkNLl6rGhTu9kj8YsF5fqqAl59OVqjwifaPq50QMbaLfn%2FnIs%2B0ucz2m%2BIfXOvHezZkTe731mdreXdMr%2BcFxH3%2BawT7wV6ajsijhMz1ayDSgSKK%2F7n5LpUwZgyVgs5EJkTRfX6e%2BoAe%2BhKU3o8eAsGihuorHqWe1WquHWDZ7hrnx3%2FivfTUuat9EPJhpidIfjONclFNm9YheTFw%3D%3D&version=1.0&notify_url=https%3A%2F%2Fyun.jiandanhome.com%2Fepay%2Falipay%2Fpay_notify%2F&sign_type=RSA2&method=alipay.trade.app.pay"}
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
         * response : format=json&timestamp=2020-03-25+11%3A11%3A31&charset=utf-8&app_id=2021001139664395&biz_content=%7B%22body%22%3A%22%E6%97%A0%E4%B8%BA%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95%22%2C%22merchant_order_no%22%3A%2276fa6d9411eaa0e5000c29c3a8b3%22%2C%22out_trade_no%22%3A%22W6IP0ANQ6056af0a6db811eaa8e900163e0ad880%22%2C%22subject%22%3A%22%E6%94%AF%E4%BB%98%E6%B5%8B%E8%AF%95%22%2C%22timeout_express%22%3A%2260m%22%2C%22total_amount%22%3A%220.01%22%7D&sign=aYrkMIgdH3ZzFEVCfg7KM%2BwPeVD1P%2B2TaxHkBjEjqkETQwcFP2%2B71qDY%2FK2Qptz9I1pUQZ7vY1ffgsayY7PnL33u3xCJAARE9V7k3V1hJAbgteu0OmbQW1m1%2Fx1IcrrmUkWVlEPAkNLl6rGhTu9kj8YsF5fqqAl59OVqjwifaPq50QMbaLfn%2FnIs%2B0ucz2m%2BIfXOvHezZkTe731mdreXdMr%2BcFxH3%2BawT7wV6ajsijhMz1ayDSgSKK%2F7n5LpUwZgyVgs5EJkTRfX6e%2BoAe%2BhKU3o8eAsGihuorHqWe1WquHWDZ7hrnx3%2FivfTUuat9EPJhpidIfjONclFNm9YheTFw%3D%3D&version=1.0&notify_url=https%3A%2F%2Fyun.jiandanhome.com%2Fepay%2Falipay%2Fpay_notify%2F&sign_type=RSA2&method=alipay.trade.app.pay
         */

        private String response;

        public String getResponse() {
            return response;
        }

        public void setResponse(String response) {
            this.response = response;
        }
    }
}
