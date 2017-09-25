package com.exz.gametrade.gametrade.adapter

import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.entity.GamePropsEntity
import kotlinx.android.synthetic.main.lay_game_props.view.*
import kotlinx.android.synthetic.main.lay_game_props_num.view.*

/**
 * Created by pc on 2017/9/18.
 */

class GamePropsAdapter(internal var state: Int//1 首页 2 售卖
                       , data: List<GamePropsEntity>?) : BaseQuickAdapter<GamePropsEntity, BaseViewHolder>(R.layout.item_game_props, data) {

    override fun convert(helper: BaseViewHolder, item: GamePropsEntity) {
        val v = helper.itemView
        v.title.text = item.title
        v.stock.text = item.stock
        v.price.text=item.price

        if (item.isCheck) {

        }
        when (state) {
            1 -> {
                v.check.visibility = View.GONE
                v.llLayNum.visibility = View.GONE
            }
            2 -> {
                v.check.visibility = View.GONE
                v.llLayNum.visibility = View.VISIBLE
            }
            3 -> v.check.visibility = View.VISIBLE
        }

    }
}
