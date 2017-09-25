package com.exz.gametrade.gametrade.adapter;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.activity.LoginActivity;
import com.exz.gametrade.gametrade.entity.SelectGamEntity;
import com.exz.gametrade.gametrade.utils.RecycleViewDivider;
import com.szw.framelibrary.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 2017/9/19.
 */

public class SelectGameAdapter extends BaseQuickAdapter<SelectGamEntity, BaseViewHolder> {

    @BindView(R.id.letter)
    TextView letter;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    public SelectGameAdapter() {
        super(R.layout.item_select_game, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectGamEntity item) {
        ButterKnife.bind(this, helper.itemView);
        letter.setText(item.getLetter());

        ItemSelectGameAdapter adapter = new ItemSelectGameAdapter();
        adapter.setEmptyView(LayoutInflater.from(mContext).inflate(R.layout.view_empty, new RelativeLayout(mContext), false));
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.addItemDecoration(new RecycleViewDivider(mContext, LinearLayoutManager.VERTICAL,
                1, ContextCompat.getColor(mContext, R.color.line_bg)));
        adapter.setNewData(item.getLetterList());
        adapter.getSelectState(new ItemSelectGameAdapter.onSelectState() {
            @Override
            public void SelectState() {
                if ( ((Activity)mContext).getIntent().getStringExtra("className").equals(mContext.getString(R.string.SelectGame))) {

                    ((Activity)mContext).finish();
                }
                Utils.INSTANCE.startActivity(mContext, LoginActivity.class);
            }
        });
    }
}
