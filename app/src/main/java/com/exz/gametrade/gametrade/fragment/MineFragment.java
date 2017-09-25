package com.exz.gametrade.gametrade.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.activity.BalanceActivity;
import com.exz.gametrade.gametrade.activity.MyConsignmentActivity;
import com.exz.gametrade.gametrade.activity.MyOrderActivity;
import com.exz.gametrade.gametrade.activity.SettingActiity;
import com.exz.gametrade.gametrade.activity.SwitchAreaActivity;
import com.exz.gametrade.gametrade.activity.SwitchMoneyActivity;
import com.exz.gametrade.gametrade.utils.SPutils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.szw.framelibrary.base.MyBaseFragment;
import com.szw.framelibrary.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by pc on 2017/9/18.
 */

public class MineFragment extends MyBaseFragment {

    @BindView(R.id.header)
    SimpleDraweeView header;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.gameName)
    TextView gameName;
    @BindView(R.id.gameArea)
    TextView gameArea;
    @BindView(R.id.currenbBalnce)
    TextView currenbBalnce;
    @BindView(R.id.SwitchMoney)
    TextView SwitchMoney;
    @BindView(R.id.Language)
    TextView Language;
    Unbinder unbinder;
    public static final int RESULTCODE_SWITCHMONEY = 1001;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_mine, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void initView() {
        if(!TextUtils.isEmpty(SPutils.getString(getContext(),"language"))){
            Language.setText(SPutils.getString(getContext(),"language"));
        }


    }

    @OnClick({R.id.setting, R.id.switchArea, R.id.llBalance, R.id.llMyOrder, R.id.llMyJS, R.id.llSwitchMoney, R.id.llLanguage})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting://设置
                Utils.INSTANCE.startActivity(getContext(), SettingActiity.class);
                break;
            case R.id.switchArea://切换区服
                Utils.INSTANCE.startActivity(getContext(), SwitchAreaActivity.class);
                break;
            case R.id.llBalance://我的余额
                Utils.INSTANCE.startActivity(getContext(), BalanceActivity.class);
                break;
            case R.id.llMyOrder://我的订单
                Utils.INSTANCE.startActivity(getContext(), MyOrderActivity.class);
                break;
            case R.id.llMyJS://我的寄售
                Utils.INSTANCE.startActivity(getContext(), MyConsignmentActivity.class);
                break;
            case R.id.llSwitchMoney://切换币种
                startActivityForResult(new Intent(getContext(), SwitchMoneyActivity.class).putExtra("result", SwitchMoney.getText().toString().trim()).putExtra("className", getString(R.string.Switch_money)), RESULTCODE_SWITCHMONEY);
                break;
            case R.id.llLanguage://切换语言
                startActivityForResult(new Intent(getContext(), SwitchMoneyActivity.class).putExtra("result", Language.getText().toString().trim()).putExtra("className", getString(R.string.language)), RESULTCODE_SWITCHMONEY);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case RESULTCODE_SWITCHMONEY:
                SwitchMoney.setText(data.getStringExtra("result"));
                break;
        }
    }

}
