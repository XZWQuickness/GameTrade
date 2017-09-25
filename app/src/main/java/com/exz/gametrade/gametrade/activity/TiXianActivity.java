package com.exz.gametrade.gametrade.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.exz.gametrade.gametrade.R;
import com.szw.framelibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pc on 2017/9/19.
 * 申请提现
 */

public class TiXianActivity extends BaseActivity {
    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.balance)
    TextView balance;
    @BindView(R.id.edBalance)
    com.szw.framelibrary.view.ClearWriteEditText edBalance;
    @BindView(R.id.edBankNum)
    com.szw.framelibrary.view.ClearWriteEditText edBankNum;
    @BindView(R.id.edBankName)
    com.szw.framelibrary.view.ClearWriteEditText edBankName;
    @BindView(R.id.edName)
    com.szw.framelibrary.view.ClearWriteEditText edName;
    @BindView(R.id.edphone)
    com.szw.framelibrary.view.ClearWriteEditText edphone;

    @Override
    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText(getString(R.string.ApplyCash));
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
        return R.layout.activity_tixian;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.Confirm)
    public void onViewClicked() {
        finish();
    }
}
