package com.eju.cy.paylibrary.dialog;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.alipay.sdk.app.PayTask;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.eju.cy.paylibrary.R;
import com.eju.cy.paylibrary.dto.LaunchPayBean;
import com.eju.cy.paylibrary.dto.PayResult;
import com.eju.cy.paylibrary.dto.UpdateTradingStatusBean;
import com.eju.cy.paylibrary.dto.ZhiFuBaoSigBean;
import com.eju.cy.paylibrary.net.AppNetInterface;
import com.eju.cy.paylibrary.net.ParameterUtils;
import com.eju.cy.paylibrary.net.RetrofitManager;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


@SuppressLint("ValidFragment")
public class PayDialog extends DialogFragment implements View.OnClickListener {

    private RelativeLayout rl_dialog, rl_wx_pay, rl_zfb_pay;


    private boolean isTouchOutside;
    private Disposable disposable;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    /**
     * @param isTouchOutside 点击外边沿是否消失
     */
    @SuppressLint("ValidFragment")
    public PayDialog(boolean isTouchOutside) {
        this.isTouchOutside = isTouchOutside;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        WindowManager.LayoutParams params = getDialog().getWindow()
                .getAttributes();
        params.gravity = Gravity.CENTER;//居中
        params.windowAnimations = R.style.bottomSheet_animation;
        getDialog().getWindow().setAttributes(params);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(isTouchOutside);//边缘不可消失
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        View view = inflater.inflate(R.layout.jx_pay_dialog_layout, container, false);

        rl_dialog = (RelativeLayout) view.findViewById(R.id.rl_dialog);
        rl_wx_pay = (RelativeLayout) view.findViewById(R.id.rl_wx_pay);
        rl_zfb_pay = (RelativeLayout) view.findViewById(R.id.rl_zfb_pay);


        rl_dialog.setOnClickListener(this);
        rl_wx_pay.setOnClickListener(this);
        rl_zfb_pay.setOnClickListener(this);


        return view;
    }


    //全屏
    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            Window window = dialog.getWindow();
            window.setGravity(Gravity.BOTTOM);
            window.setWindowAnimations(R.style.bottomSheet_animation);
            window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            window.setAttributes(lp);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.rl_dialog) {
            if (isTouchOutside) {
                dismiss();
            }
        } else if (v.getId() == R.id.rl_wx_pay) {


        } else if (v.getId() == R.id.rl_zfb_pay) {
            aliPay();
        }
    }


    @Override
    public void onDestroy() {
        compositeDisposable.clear();
        super.onDestroy();
    }

    private void aliPay() {

        final AppNetInterface httpInterface = RetrofitManager.getDefault().provideClientApi();
        httpInterface.launchPay(ParameterUtils.prepareFormData("76fa6d9411eaa0e5000c29c3a8b8"),
                ParameterUtils.prepareFormData("支付测试"),
                ParameterUtils.prepareFormData("曹臣支付测试"),
                ParameterUtils.prepareFormData("0.01"),
                ParameterUtils.prepareFormData("0"),
                ParameterUtils.prepareFormData(""))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .flatMap(new Function<LaunchPayBean, ObservableSource<UpdateTradingStatusBean>>() {
                    @Override
                    public ObservableSource<UpdateTradingStatusBean> apply(LaunchPayBean launchPayBean) throws Exception {

                        return httpInterface.updateTradingStatus(ParameterUtils.prepareFormData(launchPayBean.getData().getNo()),
                                ParameterUtils.prepareFormData("1"));
                    }
                }).observeOn(Schedulers.io())
                .flatMap(new Function<UpdateTradingStatusBean, ObservableSource<ZhiFuBaoSigBean>>() {
                    @Override
                    public ObservableSource<ZhiFuBaoSigBean> apply(UpdateTradingStatusBean updateTradingStatusBean) throws Exception {
                        return httpInterface.AliPay(ParameterUtils.prepareFormData(updateTradingStatusBean.getData().getNo()));
                    }
                }).observeOn(Schedulers.io())
                .flatMap(new Function<ZhiFuBaoSigBean, ObservableSource<PayResult>>() {
                    @Override
                    public ObservableSource<PayResult> apply(ZhiFuBaoSigBean zhiFuBaoSigBean) throws Exception {

                        PayTask alipay = new PayTask(getActivity());
                        Map<String, String> result = alipay.payV2(zhiFuBaoSigBean.getData().getResponse(), true);
                        PayResult payResult = new PayResult((Map<String, String>) result);
                        return Observable.just(payResult);

                    }
                }).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PayResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(PayResult payResult) {

                        if (TextUtils.equals(payResult.getResultStatus(), "9000")) {
                            ToastUtils.showLong("支付成功");
                            dismiss();
                        } else {
                            ToastUtils.showLong("支付失败");
                            dismiss();
                            LogUtils.w("支付失败" + payResult.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });




    }
}
