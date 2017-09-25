package com.exz.gametrade.gametrade.adapter;

import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.exz.gametrade.gametrade.R;
import com.exz.gametrade.gametrade.entity.SwitchAreaEntity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pc on 2017/9/20.
 */

public class SwitchAreaAdapter extends BaseQuickAdapter<SwitchAreaEntity, BaseViewHolder> {

    @BindView(R.id.name)
    TextView name;

    public SwitchAreaAdapter() {
        super(R.layout.item_switch_area, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, SwitchAreaEntity item) {
        ButterKnife.bind(this, helper.itemView);
        name.setText(item.getName());
    }
}
