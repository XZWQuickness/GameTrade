package com.exz.gametrade.gametrade.adapter

import android.support.v4.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.entity.PopSingleEntity
import kotlinx.android.synthetic.main.item_pop_screen.view.*


/**
 * Created by pc on 2017/9/19.
 */

class PopSingleAdapter : BaseQuickAdapter<PopSingleEntity, BaseViewHolder>(R.layout.item_pop_single, null) {

    override fun convert(helper: BaseViewHolder, item: PopSingleEntity) {
        val v = helper.itemView;
        v.name.setText(item.name)
        if (item.isCheck) {
            val d = ContextCompat.getDrawable(mContext, R.mipmap.ic_duihao)
            v.name.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, d, null)
        } else {
            v.name.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, null, null)
        }
    }
}
