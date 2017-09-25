package com.exz.gametrade.gametrade.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.adapter.SwitchMoneyAdapter;
import com.exz.gametrade.gametrade.appclication.App;
import com.exz.gametrade.gametrade.entity.SwitchMoneyEntity;
import com.exz.gametrade.gametrade.entity.User;
import com.exz.gametrade.gametrade.utils.LocaleUtils;
import com.exz.gametrade.gametrade.utils.RecycleViewDivider;
import com.exz.gametrade.gametrade.utils.SPutils;
import com.szw.framelibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.exz.gametrade.gametrade.fragment.MineFragment.RESULTCODE_SWITCHMONEY;

/**
 * Created by pc on 2017/9/20.
 * 切换币种
 */

public class SwitchMoneyActivity extends BaseActivity {

    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    SwitchMoneyAdapter adapter;
    List<SwitchMoneyEntity> list = new ArrayList<>();
    String result = "";

    @Override

    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText(getIntent().getStringExtra("className"));
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
        return R.layout.activity_switch_money;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        if (getIntent().getStringExtra("className").equals(getString(R.string.Switch_money))) {//切换币种
            list.add(new SwitchMoneyEntity("USD", false));
            list.add(new SwitchMoneyEntity("CNY", false));
            list.add(new SwitchMoneyEntity("JPY", false));
            list.add(new SwitchMoneyEntity("CAD", false));
            list.add(new SwitchMoneyEntity("AUD", false));
            list.add(new SwitchMoneyEntity("KRW", false));
            list.add(new SwitchMoneyEntity("HKD", false));
            list.add(new SwitchMoneyEntity("TWD", false));
        } else {
            list.add(new SwitchMoneyEntity("English", false));
            list.add(new SwitchMoneyEntity("中文", false));
        }

        adapter = new SwitchMoneyAdapter();
        adapter.setEmptyView(LayoutInflater.from(mContext).inflate(R.layout.view_empty, new RelativeLayout(mContext), false));
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter);
        adapter.setNewData(list);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, LinearLayoutManager.VERTICAL,
                1, ContextCompat.getColor(mContext, R.color.line_bg)));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter mAdapter, View view, int position) {

                for (SwitchMoneyEntity switchMoey : adapter.getData()) {
                    switchMoey.setCheck(false);
                }
                result = ((SwitchMoneyEntity) mAdapter.getData().get(position)).getName();
                ((SwitchMoneyEntity) mAdapter.getData().get(position)).setCheck(true);
                adapter.notifyDataSetChanged();
            }
        });

        if (!TextUtils.isEmpty(getIntent().getStringExtra("result")) && adapter.getData().size() > 0) {
            for (SwitchMoneyEntity s : adapter.getData()) {
                if (s.getName().equals(getIntent().getStringExtra("result"))) {
                    adapter.getData().get(adapter.getData().indexOf(s)).setCheck(true);
                    adapter.notifyItemChanged(adapter.getData().indexOf(s));
                    break;
                }
            }
        }
    }

    @OnClick(R.id.Confirm)
    public void onViewClicked() {
        if (getIntent().getStringExtra("className").equals(getString(R.string.language))) {//切换语言
            if (result.equals("中文")) {
                SPutils.save(mContext,"language","中文");
                LocaleUtils.updateLocale(mContext, LocaleUtils.LOCALE_CHINESE);//中文
            } else {
                SPutils.save(mContext,"language","English");
                LocaleUtils.updateLocale(mContext, LocaleUtils.LOCALE_ENGLISH);//英文
            }
            finishAffinity();
            User user=new User();
            user.setUserId("1");
            App.setUserInfo(user);
            startActivity(new Intent(mContext, MainActivity.class));
        } else {
            setResult(RESULTCODE_SWITCHMONEY, new Intent().putExtra("result", result));
            finish();
        }


    }
}
