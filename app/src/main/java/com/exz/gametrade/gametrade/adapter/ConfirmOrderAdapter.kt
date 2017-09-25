package com.exz.gametrade.gametrade.adapter

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.entity.ConfirmOrderEntity
import kotlinx.android.synthetic.main.lay_game_props.view.*

/**
 * Created by pc on 2017/9/19.
 */

class ConfirmOrderAdapter(data: List<ConfirmOrderEntity>?) : BaseQuickAdapter<ConfirmOrderEntity, BaseViewHolder>(R.layout.item_cofirm_order, data) {


    override fun convert(helper: BaseViewHolder, item: ConfirmOrderEntity) {
        val v = helper.itemView
       v. check.visibility = View.GONE
    }
}
