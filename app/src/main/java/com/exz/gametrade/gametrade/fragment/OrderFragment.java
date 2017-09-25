package com.exz.gametrade.gametrade.fragment;

import android.content.Intent;
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
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.activity.OrderDetailActivity;
import com.exz.gametrade.gametrade.adapter.OrderAdapter;
import com.exz.gametrade.gametrade.entity.OrderEntity;
import com.exz.gametrade.gametrade.utils.RecycleViewDivider;
import com.szw.framelibrary.base.MyBaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by pc on 2017/9/19.
 */

public class OrderFragment extends MyBaseFragment {
    private static String Fragment_Type = "Fragment_Type";
    Unbinder unbinder;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    @BindView(R.id.recyclerView)
    RecyclerView mRecyclerView;
    OrderAdapter adapter;
    List<OrderEntity> data=new ArrayList<>();
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
        refresh.setEnabled(false);
        data.add(new OrderEntity("1","3"));
        data.add(new OrderEntity("2","1"));
        data.add(new OrderEntity("2","3"));
        data.add(new OrderEntity("1","2"));
        adapter=new OrderAdapter(data);
        refresh.setEnabled(false);
        adapter.setEmptyView(LayoutInflater.from(getContext()).inflate(R.layout.view_empty, new RelativeLayout(getContext()), false));
        adapter.setHeaderAndEmpty(true);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL,
                10, ContextCompat.getColor(getContext(), R.color.line_bg)));
        mRecyclerView.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                OrderEntity order= (OrderEntity) adapter.getData().get(position);
                Intent intent=new Intent(getContext(),OrderDetailActivity.class);
                intent.putExtra("state",order.getState());
                startActivity(intent);
            }
        });
    }

    public static OrderFragment newInstance(String fragment_type) {
        Bundle bundle = new Bundle();
        OrderFragment fragment = new OrderFragment();
        bundle.putString(Fragment_Type, fragment_type);
        fragment.setArguments(bundle);
        return fragment;
    }
}
