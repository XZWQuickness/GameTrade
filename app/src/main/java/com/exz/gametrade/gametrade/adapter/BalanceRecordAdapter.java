package com.exz.gametrade.gametrade.adapter;

import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.entity.BalanceRecordEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 2017/9/20.
 */

public class BalanceRecordAdapter extends BaseQuickAdapter<BalanceRecordEntity, BaseViewHolder> {
    @BindView(R.id.img)
    ImageView img;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.dataTime)
    TextView dataTime;
    @BindView(R.id.price)
    TextView price;

    public BalanceRecordAdapter() {
        super(R.layout.item_balance_record, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, BalanceRecordEntity item) {
        ButterKnife.bind(this, helper.itemView);
        content.setText(item.getTitle());
        dataTime.setText(item.getDate());
        if (item.getIsIncrease().equals("0")) {//+
            price.setText("+" + item.getMoney());
            price.setTextColor(ContextCompat.getColor(mContext, R.color.green));
        } else {//-
            price.setText("-" + item.getMoney());
            price.setTextColor(ContextCompat.getColor(mContext, R.color.red_bg));
        }
    }
}
