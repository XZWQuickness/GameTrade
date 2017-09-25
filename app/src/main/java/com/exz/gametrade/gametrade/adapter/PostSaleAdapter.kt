package com.exz.gametrade.gametrade.adapter

import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.entity.PostSaleEntity
import kotlinx.android.synthetic.main.adapter_post_sale.view.*

/**
 * Created by pc on 2017/9/18.
 */

class PostSaleAdapter(data: List<PostSaleEntity>?) : BaseQuickAdapter<PostSaleEntity, BaseViewHolder>(R.layout.adapter_post_sale, data) {

    override fun convert(helper: BaseViewHolder, item: PostSaleEntity) {
        helper.addOnClickListener(R.id.input)
        helper.addOnClickListener(R.id.title)
        val v = helper.itemView;

        var d: Drawable
        if (item.isCheck) {
            d = ContextCompat.getDrawable(mContext, R.mipmap.select)
            v.title.setCompoundDrawablesRelativeWithIntrinsicBounds(d,null,null,null)
        } else {
            d = ContextCompat.getDrawable(mContext, R.mipmap.not_select)
            v.title.setCompoundDrawablesRelativeWithIntrinsicBounds(d,null,null,null)
        }
    }
}
