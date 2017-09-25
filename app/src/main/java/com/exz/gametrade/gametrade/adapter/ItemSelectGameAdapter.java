package com.exz.gametrade.gametrade.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.entity.SelectGamEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 2017/9/19.
 */

public class ItemSelectGameAdapter extends BaseQuickAdapter<SelectGamEntity.LetterListBean, BaseViewHolder> {
    @BindView(R.id.letter)
    TextView letter;
    @BindView(R.id.mRecyclerView)
    RecyclerView mRecyclerView;

    public ItemSelectGameAdapter() {
        super(R.layout.item_select_game, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectGamEntity.LetterListBean item) {
        ButterKnife.bind(this, helper.itemView);
        letter.setText(item.getName());
        mRecyclerView.setVisibility(View.GONE);
        letter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onSelectState != null) {
                    onSelectState.SelectState();
                }
            }
        });
    }

    public void setSelect(SelectGamEntity.LetterListBean item) {
        if (onSelectState != null) {
            onSelectState.SelectState();
            notifyDataSetChanged();
        }
    }

    public void getSelectState(onSelectState onSelectState) {
        this.onSelectState = onSelectState;
    }

    private onSelectState onSelectState;

    public interface onSelectState {
        void SelectState();
    }
}
