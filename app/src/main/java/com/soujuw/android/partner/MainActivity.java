package com.soujuw.android.partner;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.daimajia.androidanimations.library.attention.ShakeAnimator;
import com.nostra13.universalimageloader.cache.disc.impl.ext.LruDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.utils.StorageUtils;
import com.soujuw.android.partner.Debug.ExpandableDraggableSwipeableExampleActivity;
import com.soujuw.android.partner.Fragments.FragmentBase;
import com.soujuw.android.partner.Fragments.HouseExploreFragment;
import com.soujuw.android.partner.Fragments.MainFragment;
import com.soujuw.android.partner.Fragments.PartnerLoginFragment;
import com.soujuw.android.partner.Fragments.PartnerRegisterFragment;
import com.soujuw.android.partner.Fragments.PartnerRetrieveFragment;

import java.io.File;
import java.io.IOException;


public class MainActivity extends AppCompatActivity {
    public MainFragment mFragmentMain;
    public PartnerLoginFragment mFragmentPartnerLogin;
    public PartnerRegisterFragment mFragmentPartnerRegister;
    public PartnerRetrieveFragment mFragmentPartnerRetrieve;
    public HouseExploreFragment mFragmentHouseExplore;


    FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        initImageLoaderConfig();

        mFragmentManager = getSupportFragmentManager();
        mFragmentMain = new MainFragment();
        mFragmentPartnerLogin = new PartnerLoginFragment();
        mFragmentPartnerRegister = new PartnerRegisterFragment();
        mFragmentPartnerRetrieve = new PartnerRetrieveFragment();
        mFragmentHouseExplore = new HouseExploreFragment();
        FragmentBase.mMainActivity = this;
        mFragmentManager.beginTransaction()
                .add(R.id.fragment_container, mFragmentMain, "MAIN_FRAGMENT")
                .commit();

        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//mFragmentManager.putFragment(outState, "MAINFRAGMENT", mFragmentMain);
//        mFragmentManager.putFragment(outState, "PARTNER_LOGIN_FRAGMENT", mFragmentPartnerLogin);
//        mFragmentManager.putFragment(outState, "PARTNER_REGISTER_FRAGMENT", mFragmentPartnerRegister);
//        mFragmentManager.putFragment(outState, "PARTNER_RETRIEVE_FRAGMENT", mFragmentPartnerRetrieve);
//        mFragmentManager.putFragment(outState, "MAIN_FRAGMENT", mFragmentMain);

    }

    @Override
    public void onBackPressed() {
        if (isMainFragment()) {
            new AlertDialog.Builder(this, R.style.DialogTheme_Alert)
                    .setTitle(R.string.dialog_exit_confirm_title)
                    .setPositiveButton(R.string.dialog_exit_confirm_yes, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton(R.string.dialog_exit_confirm_no, null)
                    .show();
        } else {
            //TODO 不要这么简单暴力.
            showFragment(mFragmentMain);
            //super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.debug_partner_login:
                showFragment(mFragmentPartnerLogin);
                return true;
            case R.id.debug_partner_register:
                showFragment(mFragmentPartnerRegister);
                return true;
            case R.id.debug_partner_retrieve:
                showFragment(mFragmentPartnerRetrieve);
                return true;
            case R.id.debug_main_page:
                showFragment(mFragmentMain);
                return true;
            case R.id.debug_preview_house:
                Intent intent = new Intent(this, ExpandableDraggableSwipeableExampleActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    //显示指定的FRAGMENT
    public boolean showFragment(FragmentBase fragment) {
        if (fragment == null) {
            Log.e("MA.showFragment", "null fragment!");
            fragment = mFragmentMain;
        } else {
            Log.w("MA.showFragment", fragment.getClass().getName());
        }
        Fragment fragmentNow = mFragmentManager.findFragmentById(R.id.fragment_container);
        if (fragmentNow == fragment)
            return false;
        boolean bIsMainFragment = fragmentNow == mFragmentMain;

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container, fragment, fragment.getTag()) // 替换Fragment，实现切换
                .setCustomAnimations(
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right);
        if (bIsMainFragment) {
            fragmentTransaction.addToBackStack("MAIN_FRAGMENT");
        }
        //fragmentTransaction.addToBackStack("NAME");//添加到返回栈.
        fragmentTransaction.commit();//提交改变
        return true;
    }

    boolean isMainFragment(){
        return mFragmentManager.findFragmentById(R.id.fragment_container) == mFragmentMain;
    }


    void initImageLoaderConfig() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .considerExifParams(true)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .showImageOnLoading(R.drawable.ic_image_loading_16_9)

                        //.displayer(new FadeInBitmapDisplayer(200))//是否图片加载好后渐入的动画时间
                .build();
        File cache = StorageUtils.getCacheDirectory(getApplicationContext());
        ImageLoaderConfiguration config;
        try {
            config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                    .threadPoolSize(5)
                    .memoryCache(new UsingFreqLimitedMemoryCache(8 * 1024 * 1024)) // 8MB图片内存缓存
                    .diskCache(new LruDiskCache(cache, new HashCodeFileNameGenerator(), 100 * 1024 * 1024))
                    .defaultDisplayImageOptions(options)
                    .build();

        } catch (IOException e) {
            config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                    .memoryCache(new UsingFreqLimitedMemoryCache(12 * 1024 * 1024)) // 8MB图片内存缓存
                    .defaultDisplayImageOptions(options)
                    .build();
            e.printStackTrace();
        }
        ImageLoader.getInstance().init(config);
    }

    public void toast(CharSequence text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    public void toast(int textRes) {
        Toast.makeText(this, textRes, Toast.LENGTH_SHORT).show();
    }

    //shake the view. used for misinput edit...
    public void shakeAndFocus(View v) {
        new ShakeAnimator().setDuration(700).animate(v);
        v.requestFocus();
    }
}
