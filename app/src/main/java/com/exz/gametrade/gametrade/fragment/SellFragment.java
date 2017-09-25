package com.exz.gametrade.gametrade.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.activity.PostSaleActivity;
import com.exz.gametrade.gametrade.adapter.GamePropsAdapter;
import com.exz.gametrade.gametrade.entity.GamePropsEntity;
import com.exz.gametrade.gametrade.utils.RecycleViewDivider;
import com.szw.framelibrary.base.MyBaseFragment;
import com.szw.framelibrary.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pc on 2017/9/18.
 */

public class SellFragment extends MyBaseFragment implements View.OnClickListener {
    Unbinder unbinder;
    @BindView(R.id.mTitle)
    TextView mTitle;
    @BindView(R.id.mRight)
    TextView mRight;
    @BindView(R.id.mRightImg)
    ImageView mRightImg;
    @BindView(R.id.mLeftImg)
    ImageView mLeftImg;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<GamePropsEntity> data = new ArrayList<>();
    GamePropsAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_sell, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void initView() {
        initToolbar();
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        adapter = new GamePropsAdapter(1, data);
        adapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.view_empty, new RelativeLayout(getContext()), false));
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL,
                10, ContextCompat.getColor(getContext(), R.color.line_bg)));
        refresh.setEnabled(false);
    }

    private void initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0);
        toolbar.setNavigationContentDescription(null);
        mTitle.setTextSize(16);
        mTitle.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        mTitle.setText("魔兽世界");
        mLeftImg.setVisibility(View.GONE);
        mRight.setTextSize(16);
        mRight.setTextColor(ContextCompat.getColor(getContext(), R.color.white));
        mRight.setText(getString(R.string.Post_sale));
        toolbar.setBackgroundResource(R.color.blue);
        mRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mRight://发布出售
                Utils.INSTANCE.startActivity(getContext(), PostSaleActivity.class);
                break;
        }
    }
}
