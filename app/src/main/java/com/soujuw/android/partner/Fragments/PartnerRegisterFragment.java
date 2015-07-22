package com.soujuw.android.partner.Fragments;

import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.rey.material.widget.CompoundButton;
import com.soujuw.android.partner.R;
import com.soujuw.android.partner.Views.CellphoneEdit;
import com.soujuw.android.partner.Views.PasswordEdit;
import com.soujuw.android.partner.Views.VerifyCodeEdit;

import org.apache.http.Header;

import java.io.UnsupportedEncodingException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//import com.rey.material.widget.CompoundButton;


public class PartnerRegisterFragment extends FragmentBase {
    @Bind(R.id.edit_register_cellphone)
    CellphoneEdit editCellphone;
    @Bind(R.id.edit_register_password)
    PasswordEdit editPassword;
    @Bind(R.id.edit_register_confirmpw)
    PasswordEdit editConfirmPW;
    @Bind(R.id.edit_register_verify)
    VerifyCodeEdit editVerifyCode;
    @Bind(R.id.action_register_get_verify)
    CompoundButton btnGetVerifyCode;
    @Bind(R.id.action_register_submit)
    CompoundButton btnSubmitRegister;

    //    @InjectView(R.id.edit_register_confirmpw)
//    TextView v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mMainActivity.getSupportActionBar().hide();
        View view = inflater.inflate(R.layout.fragment_parter_register, null);
        ButterKnife.bind(this, view);
        mMainActivity.setTitle(R.string.toolbar_title_partner_register);
        return view;
    }

    @OnClick(R.id.action_register_switch_login)
    void onSwitchToLogin() {
        if (mMainActivity != null) {
            mMainActivity.showFragment(mMainActivity.mFragmentPartnerLogin);
        }
    }

    @OnClick(R.id.action_register_switch_retrive)
    void onSwitchToRetrieve() {
        if (mMainActivity != null) {
            mMainActivity.showFragment(mMainActivity.mFragmentPartnerRetrieve);
        }
    }

    @OnClick(R.id.action_register_submit)
    void onSubmitRegister() {
        if (!editCellphone.validate()) {
            editCellphone.askForCorrection();
            return;
        }
        if (editCellphone.isEmpty()) {
            editCellphone.askForCorrection("请您填写手机号");
            return;
        }
        if (!editPassword.validate()) {
            editPassword.askForCorrection();
            return;
        }
        if (editPassword.isEmpty()) {
            editPassword.askForCorrection("请您设置密码");
            return;
        }
        if (!editConfirmPW.validate()) {
            editConfirmPW.askForCorrection();
            return;
        }
        if (editConfirmPW.isEmpty()) {
            editConfirmPW.askForCorrection("请确认您的密码");
            return;
        }
        if (editConfirmPW.getText() != editPassword.getText()) {
            editConfirmPW.askForCorrection("密码输入不一致");
            return;
        }
        if (!editVerifyCode.validate()) {
            editVerifyCode.askForCorrection();
            return;
        }
        if (editVerifyCode.isEmpty()) {
            editVerifyCode.askForCorrection("请填写验证码");
        }
        RequestParams params = new RequestParams();
        params.add("cellphone", editCellphone.getText().toString());
        params.add("password", editPassword.getText().toString());
        params.add("verifycode", editVerifyCode.getText().toString());
        String param = params.toString();
        new AsyncHttpClient().get(getActivity(),
                "http://192.168.100.145:8080/partner/page/login/usersLogin!sendMobile3.action",
                new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

                    }
                }
        );
        btnSubmitRegister.setEnabled(false);
        if (btnSubmitRegister.getParent() instanceof CardView) {
            ((CardView) btnSubmitRegister.getParent()).setCardElevation(0);
        }
        //TODO 注册按钮动画...
    }

    @OnClick(R.id.action_register_get_verify)
    void onGetVerifyCode() {
        //http://192.168.100.145:8080/partner/page/login/usersLogin!sendMobile3.action?cellPhone=18604209112
        AsyncHttpClient client = new AsyncHttpClient();

        String url = "http://192.168.100.145:8080/partner/page/login/usersLogin!sendMobile3.action?cellPhone=" + editCellphone.getText();
        client.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                mMainActivity.toast(R.string.register_verify_code_sent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                if (error != null) {
                    mMainActivity.toast("网络访问错误");
                    return;
                }
                if (responseBody == null) {
                    mMainActivity.toast("获取验证码失败,原因未知");
                    return;
                }
                try {
                    String s = new String(responseBody, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    mMainActivity.toast("获取验证码失败,回报无法识别");
                    return;
                }
                if (statusCode != 400) {
                    mMainActivity.toast("获取验证码失败,状态码" + statusCode);
                    return;
                }

                if (statusCode == 1) {
                    //...
                }//...
            }
        });
    }
}
