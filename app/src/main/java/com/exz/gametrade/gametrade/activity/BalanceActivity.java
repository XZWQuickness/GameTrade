package com.exz.gametrade.gametrade.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.exz.gametrade.gametrade.R;
import com.szw.framelibrary.base.BaseActivity;
import com.szw.framelibrary.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pc on 2017/9/19.
 */

public class BalanceActivity extends BaseActivity {


    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.balance)
    TextView balance;

    @Override
    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText(getString(R.string.MyBalance));
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
        return R.layout.fragment_balance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.BalanceRecord,R.id.BalancePay, R.id.ApplyForWithdraw})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.BalanceRecord://余额记录
                Utils.INSTANCE.startActivity(mContext, BalanceRecordActivity.class);
                break;
            case R.id.BalancePay://余额充值
                Utils.INSTANCE.startActivity(mContext, BalancePayActivity.class);
                break;
            case R.id.ApplyForWithdraw://申请提现
                Utils.INSTANCE.startActivity(mContext, TiXianActivity.class);
                break;
        }
    }
}
