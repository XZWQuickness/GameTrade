package com.exz.gametrade.gametrade.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.exz.gametrade.gametrade.R;
import com.szw.framelibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pc on 2017/9/19.
 * 订单详情
 */

public class OrderDetailActivity extends BaseActivity {
    @BindView(R.id.llLay)
    LinearLayout llLay;
    @BindView(R.id.state)
    TextView state;
    @BindView(R.id.llLayGameGoods)
    LinearLayout llLayGameGoods;
    @BindView(R.id.llPayTime)
    LinearLayout llPayTime;
    @BindView(R.id.llPayType)
    LinearLayout llPayType;
    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText(getString(R.string.orderDetail));
        toolbar.setBackgroundResource(R.color.blue);
        return false;
    }

    @Override
    public int setInflateId() {
        return R.layout.activity_order_detail;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        llLayGameGoods.removeAllViews();
        for (int i = 0; i < 3; i++) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.lay_order_detail, null);
            llLayGameGoods.addView(v);
        }
        if (getIntent().getStringExtra("state").equals("1")) {
            state.setText(getString(R.string.NoPayment));
        } else {
            state.setText(getString(R.string.AccountPaid));
            llLay.setVisibility(View.VISIBLE);
            llPayTime.setVisibility(View.VISIBLE);
            llPayType.setVisibility(View.VISIBLE);
        }
    }

    @OnClick({R.id.mLeftImg, R.id.mLeftBt, R.id.mRightBt})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mLeftImg:
                finish();
                break;
            case R.id.mLeftBt:
                break;
            case R.id.mRightBt:
                break;
        }
    }

}
