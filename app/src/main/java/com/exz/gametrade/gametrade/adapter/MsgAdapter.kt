package com.exz.gametrade.gametrade.adapter

import butterknife.ButterKnife
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.entity.MessageEntity
import java.util.*

/**
 * Created by pc on 2017/9/21.
 */

class MsgAdapter<T:MessageEntity> : BaseQuickAdapter<T, BaseViewHolder>(R.layout.item_msg, ArrayList<T>() ) {

    override fun convert(helper: BaseViewHolder, item: T) {
        ButterKnife.bind(this, helper.itemView)

    }
}
