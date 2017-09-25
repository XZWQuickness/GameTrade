package com.exz.gametrade.gametrade.adapter;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.entity.OrderEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 2017/9/19.
 */

public class OrderAdapter extends BaseQuickAdapter<OrderEntity, BaseViewHolder> {

    @BindView(R.id.state)
    TextView state;
    @BindView(R.id.mLeftBt)
    TextView mLeft;
    @BindView(R.id.mRightBt)
    TextView mRight;
    @BindView(R.id.llLayGameGoods)
    LinearLayout llLayGameGoods;
    @BindView(R.id.llLay)
    LinearLayout llLay;

    public OrderAdapter(@Nullable List<OrderEntity> data) {
        super(R.layout.item_order, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, OrderEntity item) {
        ButterKnife.bind(this, helper.itemView);
        llLayGameGoods.removeAllViews();
        for (int i = 0; i < Integer.parseInt(item.getNum()); i++) {
            View v = LayoutInflater.from(mContext).inflate(R.layout.lay_game_goods, null);
            llLayGameGoods.addView(v);
        }
        switch (item.getState()) {
            case "1":
                state.setText(mContext.getString(R.string.NoPayment));
                llLay.setVisibility(View.VISIBLE);
                break;
            case "2":
                llLay.setVisibility(View.GONE);
                state.setText(mContext.getString(R.string.AccountPaid));
                break;
        }
    }
}
