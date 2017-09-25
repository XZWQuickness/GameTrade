package com.exz.gametrade.gametrade.adapter;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.entity.SwitchMoneyEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 2017/9/20.
 */

public class SwitchMoneyAdapter extends BaseQuickAdapter<SwitchMoneyEntity, BaseViewHolder> {
    @BindView(R.id.name)
    TextView name;

    public SwitchMoneyAdapter() {
        super(R.layout.item_switch_money, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, SwitchMoneyEntity item) {
        ButterKnife.bind(this, helper.itemView);
        name.setText(item.getName());
        Drawable d = null;
        if (item.getCheck()) {
            d = ContextCompat.getDrawable(mContext, R.mipmap.ic_order_pay_check);
        } else {
            d = ContextCompat.getDrawable(mContext, R.mipmap.not_select);
        }
        name.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, d, null);
    }
}
