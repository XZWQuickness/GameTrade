package com.exz.gametrade.gametrade.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.entity.PopScreenEntity

/**
 * Created by pc on 2017/9/20.
 */

class PopScreenAdapter : BaseQuickAdapter<PopScreenEntity, BaseViewHolder>(R.layout.item_pop_screen, null) {

    override fun convert(helper: BaseViewHolder, item: PopScreenEntity) {
        val v = helper.itemView;
    }
}
