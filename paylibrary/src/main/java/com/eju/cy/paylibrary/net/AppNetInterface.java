package com.eju.cy.paylibrary.net;


import com.eju.cy.paylibrary.dto.LaunchPayBean;
import com.eju.cy.paylibrary.dto.UpdateTradingStatusBean;
import com.eju.cy.paylibrary.dto.ZhiFuBaoSigBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface AppNetInterface {


    /**
     * @param order_no     业务订单编号
     * @param subject      交易标题
     * @param order_des    业务订单描述
     * @param total_amount 交易金额
     * @param order_batch  订单交易资金类型 【0：其他 1：押金 2：订金，预付款 3：尾款】
     * @param extend_info  JSON 字符串
     * @return
     */
    @Multipart
    @POST("epay/order/launch/")
    Observable<LaunchPayBean> launchPay(@Part("order_no") RequestBody order_no,
                                        @Part("subject") RequestBody subject,
                                        @Part("order_des") RequestBody order_des,

                                        @Part("total_amount") RequestBody total_amount,
                                        @Part("order_batch") RequestBody order_batch,
                                        @Part("extend_info") RequestBody extend_info

    );

    /**
     * 支付宝支付签名
     *
     * @param order_no 支付交易唯一编号 5VX407YQ2a2bc0846e4711eab95a00163e0ad880
     * @return ：根据支付交易编号 生成APP端交易 签名结果集
     */
    @Multipart
    @POST("epay/alipay/app_trade/")
    Observable<ZhiFuBaoSigBean> AliPay(@Part("no") RequestBody order_no


    );


    /**
     * 更新付款方式，同时订单由发起交易到交易进行中
     *
     * @param order_no 支付订单唯一编号
     * @param pay_type 付款方式 【0：未选择 1：支付宝 2：微信支付 3：银联支付 4：拉卡拉PAY 】
     * @return
     */
    @Multipart
    @POST("epay/order/trading/")
    Observable<UpdateTradingStatusBean> updateTradingStatus(@Part("no") RequestBody order_no,
                                                            @Part("pay_type") RequestBody pay_type


    );


//    /**
//     * @ Name: Caochen
//     * @ Date: 2020-03-11
//     * @ Time: 16:51
//     * @ Description：  生成房间号
//     */
//

//
//
//    /**
//     * @ Name: Caochen
//     * @ Date: 2020-03-12
//     * @ Time: 06:56
//     * @ Description： 查询状态
//     */
//
//    @GET("av/rtc/by_call/")
//    Observable<CallRecordsDto> byCall();
//
//    /**
//     * @ Name: Caochen
//     * @ Date: 2020-03-13
//     * @ Time: 12:10
//     * @ Description： 签名
//     */
//    @Multipart
//    @POST("av/usersig/gen_user_sig/")
//    Observable<SigDto> genUserSig(@Part("appType") RequestBody appType);
//
//
//    /**
//     * @ Name: Caochen
//     * @ Date: 2020-03-13
//     * @ Time: 12:10
//     * @ Description：  更改通话状态  av/rtc/update_talk_status/
//     */
//
//
//    @Multipart
//    @POST("av/rtc/update_talk_status/")
//    Observable<UpdateStatusDto> updateTalkStatus(@Part("id") RequestBody id, @Part("talk_status") RequestBody talk_status);
//
//
//    /**
//     * @ Name: Caochen
//     * @ Date: 2020-03-13
//     * @ Time: 12:10
//     * @ Description：  更改房间状态  av/rtc/update_talk_status/
//     */
//
//
//    @Multipart
//    @POST("av/rtc/update_room_status/")
//    Observable<UpdateStatusDto> updateRoomStatus(@Part("id") RequestBody id, @Part("room_status") RequestBody room_status);
//

}
