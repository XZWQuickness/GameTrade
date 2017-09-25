package com.exz.gametrade.gametrade.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.adapter.SwitchAreaAdapter;
import com.exz.gametrade.gametrade.entity.SwitchAreaEntity;
import com.exz.gametrade.gametrade.utils.RecycleViewDivider;
import com.szw.framelibrary.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by pc on 2017/9/20.
 * 切换区服
 */

public class SwitchAreaActivity extends BaseActivity {
    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.mRight)
    TextView mRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;
    SwitchAreaAdapter adapter;
    List<SwitchAreaEntity> list = new ArrayList<>();

    @Override
    public boolean initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mTitle.setText(getString(R.string.SwitchingArea));

        mRight.setTextSize(16);
        mRight.setTextColor(ContextCompat.getColor(mContext, R.color.white));
        mRight.setText(getString(R.string.confirm));
        toolbar.setBackgroundResource(R.color.blue);
        return false;
    }

    @Override
    public int setInflateId() {
        return R.layout.activity_switch_area;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        tv1.setTag("1");
        tv2.setTag("2");
        initView();
    }

    private void initView() {
        list.add(new SwitchAreaEntity("一区"));
        list.add(new SwitchAreaEntity("二区"));
        list.add(new SwitchAreaEntity("三区"));
        list.add(new SwitchAreaEntity("四区"));
        list.add(new SwitchAreaEntity("五区"));
        adapter = new SwitchAreaAdapter();
        adapter.setEmptyView(LayoutInflater.from(mContext).inflate(R.layout.view_empty, new RelativeLayout(mContext), false));
        adapter.setNewData(list);
        adapter.setHeaderAndEmpty(true);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, LinearLayoutManager.VERTICAL,
                1, ContextCompat.getColor(mContext, R.color.line_bg)));
    }

    @OnClick({R.id.mRight, R.id.tv1, R.id.tv2, R.id.mLeftImg})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mRight:
                finish();
                break;
            case R.id.mLeftImg:
                finish();
                break;
            case R.id.tv1:
                list.clear();
                list.add(new SwitchAreaEntity("一区"));
                list.add(new SwitchAreaEntity("二区"));
                list.add(new SwitchAreaEntity("三区"));
                list.add(new SwitchAreaEntity("四区"));
                list.add(new SwitchAreaEntity("五区"));
                tv1.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                tv2.setBackgroundColor(ContextCompat.getColor(mContext, R.color.app_bg));
                adapter.setNewData(list);
                break;
            case R.id.tv2:
                list.clear();
                list.add(new SwitchAreaEntity("正服"));
                list.add(new SwitchAreaEntity("体验服"));
                tv1.setBackgroundColor(ContextCompat.getColor(mContext, R.color.app_bg));
                tv2.setBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
                adapter.setNewData(list);
                break;
        }
    }
}
