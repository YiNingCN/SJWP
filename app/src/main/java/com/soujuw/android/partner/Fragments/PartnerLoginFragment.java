package com.soujuw.android.partner.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soujuw.android.partner.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class PartnerLoginFragment extends FragmentBase {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parter_login, null);
        ButterKnife.bind(this, view);
        mMainActivity.setTitle(R.string.toolbar_title_partner_login);
        return view;
    }

    @OnClick(R.id.action_login_switch_register) void onSwitchToRegister(){
        if(mMainActivity != null){
            mMainActivity.showFragment(mMainActivity.mFragmentPartnerRegister);
        }

    }
    @OnClick(R.id.action_login_switch_retrieve) void onSwitchToRetrieve(){
        if(mMainActivity != null){
            mMainActivity.showFragment(mMainActivity.mFragmentPartnerRetrieve);
        }
    }
}
