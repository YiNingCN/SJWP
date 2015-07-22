package com.soujuw.android.partner.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.soujuw.android.partner.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainFragment extends FragmentBase {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);//注入
        mMainActivity.setTitle(R.string.app_title);
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        ButterKnife.unbind(this);
    }

    @OnClick({

            R.id.function_main_house_manage,
            R.id.function_main_new_building,
            R.id.function_main_client_explore,
            R.id.function_main_client_manage,
            R.id.function_main_soujubao,
            R.id.function_main_soujudian,
            R.id.function_main_my_account,
            R.id.function_main_more
    })
    public void onClick(View v) {
        Toast.makeText(getActivity(), ((TextView)v).getText()+"正在开发中...",Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.function_main_house_explore)
    public void houseExplore(View v) {
        mMainActivity.showFragment(mMainActivity.mFragmentHouseExplore);
    }

}
