package com.exz.gametrade.gametrade.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.fragment.OrderFragment;
import com.flyco.tablayout.SlidingTabLayout;
import com.szw.framelibrary.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static butterknife.internal.Utils.arrayOf;

/**
 * Created by pc on 2017/9/19.
 * 我的订单
 */

public class MyOrderActivity extends BaseActivity {
    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mainTabBar)
    SlidingTabLayout mainTabBar;
    @BindView(R.id.pager)
    ViewPager pager;
    ArrayList<Fragment> list = new ArrayList<>();

    @Override
    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText(getString(R.string.my_order));
        toolbar.setBackgroundResource(R.color.blue);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        return false;
    }

    @Override
    public int setInflateId() {
        return R.layout.activity_my_order;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        list.add(OrderFragment.newInstance("0"));
        list.add(OrderFragment.newInstance("1"));
        list.add(OrderFragment.newInstance("2"));
        String[] tabTitles = arrayOf(getString(R.string.all), getString(R.string.NoPayment), getString(R.string.AccountPaid));
        mainTabBar.setViewPager(pager, tabTitles, this, list);
    }
}
