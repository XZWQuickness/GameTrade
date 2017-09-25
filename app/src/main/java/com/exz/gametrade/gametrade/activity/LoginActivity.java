package com.exz.gametrade.gametrade.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.appclication.App;
import com.exz.gametrade.gametrade.entity.User;
import com.szw.framelibrary.base.BaseActivity;
import com.szw.framelibrary.view.ClearWriteEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pc on 2017/9/18.
 * 登录
 */

public class LoginActivity extends BaseActivity {
    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.edGameName)
    ClearWriteEditText edGameName;
    @BindView(R.id.edGamePsd)
    ClearWriteEditText edGamePsd;

    @Override
    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText(getString(R.string.LogInTheGame));
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
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.LogoIn)
    public void onViewClicked() {
        User user=new User();
        user.setUserId("1");
        App.setUserInfo(user);
        finish();
    }
}
