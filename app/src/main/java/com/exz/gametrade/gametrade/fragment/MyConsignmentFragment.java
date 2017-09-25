package com.exz.gametrade.gametrade.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.adapter.GamePropsAdapter;
import com.exz.gametrade.gametrade.entity.GamePropsEntity;
import com.exz.gametrade.gametrade.utils.RecycleViewDivider;
import com.szw.framelibrary.base.MyBaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pc on 2017/9/20.
 */

public class MyConsignmentFragment extends MyBaseFragment {

    private static String Fragment_Type = "Fragment_Type";
    Unbinder unbinder;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    GamePropsAdapter adapter;
    List<GamePropsEntity> data = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.refresh_recycler, container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void initView() {
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        data.add(new GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"));
        adapter = new GamePropsAdapter(2, data);
        adapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.view_empty, new RelativeLayout(getContext()), false));
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL,
                10, ContextCompat.getColor(getContext(), R.color.line_bg)));
    }

    public static MyConsignmentFragment newInstance(String fragment_type) {
        Bundle bundle = new Bundle();
        MyConsignmentFragment fragment = new MyConsignmentFragment();
        bundle.putString(Fragment_Type, fragment_type);
        fragment.setArguments(bundle);
        return fragment;
    }
}
