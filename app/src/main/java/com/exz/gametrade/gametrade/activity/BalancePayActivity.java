package com.exz.gametrade.gametrade.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.exz.gametrade.gametrade.R;
import com.szw.framelibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pc on 2017/9/19.
 */

public class BalancePayActivity extends BaseActivity {

    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rb)
    RadioGroup rb;

    @Override
    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText("余额充值");
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
        return R.layout.activity_pay_balance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.pay)
    public void onViewClicked() {
        finish();
    }
}
