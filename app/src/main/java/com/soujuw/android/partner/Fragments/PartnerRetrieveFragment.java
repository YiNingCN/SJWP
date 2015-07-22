package com.soujuw.android.partner.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soujuw.android.partner.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class PartnerRetrieveFragment extends FragmentBase {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parter_retrieve, null);
        ButterKnife.bind(this, view);
        mMainActivity.setTitle(R.string.toolbar_title_partner_retrieve);
        return view;
    }
    @OnClick(R.id.action_retrieve_switch_register) void onSwitchToRegister(){
        if(mMainActivity != null){
            mMainActivity.showFragment(mMainActivity.mFragmentPartnerRegister);
        }

    }
    @OnClick(R.id.action_retrieve_switch_login) void onSwitchToLogin(){
        if(mMainActivity != null){
            mMainActivity.showFragment(mMainActivity.mFragmentPartnerLogin);
        }
    }


}
