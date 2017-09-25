package com.exz.gametrade.gametrade.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.adapter.BalanceRecordAdapter;
import com.exz.gametrade.gametrade.entity.BalanceRecordEntity;
import com.exz.gametrade.gametrade.utils.RecycleViewDivider;
import com.szw.framelibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 2017/9/20.
 * 余额记录
 */

public class BalanceRecordActivity extends BaseActivity {
    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    BalanceRecordAdapter adapter;

    @Override
    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText(getString(R.string.BalanceRecord));
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
        return R.layout.activity_balance_record;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        refresh.setEnabled(false);
        adapter = new BalanceRecordAdapter();
        adapter.setEmptyView(LayoutInflater.from(mContext).inflate(R.layout.view_empty, new RelativeLayout(mContext), false));
        adapter.setHeaderAndEmpty(true);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, LinearLayoutManager.VERTICAL,
                10, ContextCompat.getColor(mContext, R.color.line_bg)));
        adapter.setNewData(JSON.parseArray(json, BalanceRecordEntity.class));
    }

    String json = "[\n" +
            "    {\n" +
            "        \"title\": \"支付宝账号充值\",\n" +
            "        \"date\": \"2017-9-12 12:00\",\n" +
            "        \" money\": \"￥100\",\n" +
            "        \"isIncrease\": \"0\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"title\": \"订单2364消费\",\n" +
            "        \"date\": \"2017-9-12 14:00\",\n" +
            "        \" money\": \"￥10\",\n" +
            "        \"isIncrease\": \"1\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"title\": \"微信账号充值\",\n" +
            "        \"date\": \"2017-7-12 10:00\",\n" +
            "        \" money\": \"￥100\",\n" +
            "        \"isIncrease\": \"0\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"title\": \"提现\",\n" +
            "        \"date\": \"2017-9-20 10:00\",\n" +
            "        \" money\": \"￥80\",\n" +
            "        \"isIncrease\": \"1\"\n" +
            "    }\n" +
            "]";

}
