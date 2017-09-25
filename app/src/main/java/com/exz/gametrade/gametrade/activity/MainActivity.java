package com.exz.gametrade.gametrade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.FrameLayout;

import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.appclication.App;
import com.exz.gametrade.gametrade.entity.TabEntity;
import com.exz.gametrade.gametrade.fragment.BuyFragment;
import com.exz.gametrade.gametrade.fragment.MainFragment;
import com.exz.gametrade.gametrade.fragment.MineFragment;
import com.exz.gametrade.gametrade.fragment.SellFragment;
import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.hwangjr.rxbus.thread.EventThread;
import com.szw.framelibrary.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    private int[] mIconSelectIds = {
            R.mipmap.ic_home_1, R.mipmap.ic_sell_1,
            R.mipmap.ic_buy_1,
            R.mipmap.ic_mine_1};
    private int[] mIconUnSelectIds = {
            R.mipmap.ic_home_2, R.mipmap.ic_sell_2,
            R.mipmap.ic_buy_2,
            R.mipmap.ic_mine_2};
    @BindView(R.id.main_container)
    FrameLayout mainContainer;
    @BindView(R.id.mainTabBar)
    public CommonTabLayout mainTabBar;
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    String currentTab="";
    @Override
    public boolean initToolbar() {
        return false;
    }

    @Override
    public int setInflateId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
//
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        if(!TextUtils.isEmpty(currentTab)){
            mainTabBar.setCurrentTab(Integer.parseInt(currentTab));
            currentTab="";
        }
    }

    private void initView() {
        if ((getIntent().getFlags() & Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT) != 0) {
            finish();
            return;
        }
        String[] mTitles = {getString(R.string.home), getString(R.string.sell),getString(R.string.buy), getString(R.string.mine)};
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        }
        mFragments.add(new MainFragment());
        mFragments.add(new SellFragment());
        mFragments.add(new BuyFragment());
        mFragments.add(new MineFragment());
        mainTabBar.setTabData(mTabEntities, this, R.id.main_container, mFragments);

        mainTabBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                if (App.getLoginUserId().equals("")) {
                    if (position!=0) {
                        if (App.getLoginUserId().equals("")) {
                            mainTabBar.setCurrentTab(0);
                            startActivity(new Intent(mContext,SelectGameActivity.class).putExtra("className",   getString(R.string.SelectGame)));
                        }
                    }
                }

            }

            @Override
            public void onTabReselect(int position) {

            }
        });


    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.addCategory(Intent.CATEGORY_HOME);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Subscribe(thread = EventThread.MAIN_THREAD, tags = {@Tag("currentTab")})
    public void setCurrentTab(String currentTab) {

       this.currentTab=currentTab;
    }

}
