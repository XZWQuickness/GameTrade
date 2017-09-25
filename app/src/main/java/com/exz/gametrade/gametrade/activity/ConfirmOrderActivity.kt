package com.exz.gametrade.gametrade.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.RelativeLayout
import butterknife.ButterKnife
import butterknife.OnClick
import com.chad.library.adapter.base.BaseQuickAdapter
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.adapter.ConfirmOrderAdapter
import com.exz.gametrade.gametrade.entity.ConfirmOrderEntity
import com.exz.gametrade.gametrade.utils.RecycleViewDivider
import com.szw.framelibrary.base.BaseActivity
import com.szw.framelibrary.utils.Utils
import kotlinx.android.synthetic.main.action_bar_old.*
import kotlinx.android.synthetic.main.activity_post_sale.*
import java.util.*

/**
 * Created by pc on 2017/9/19.
 * 确认订单
 */

class ConfirmOrderActivity : BaseActivity() {
    lateinit var adapter: ConfirmOrderAdapter
    internal var data: MutableList<ConfirmOrderEntity> = ArrayList()

    override fun initToolbar(): Boolean {
        toolbar.setContentInsetsAbsolute(0, 0)
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white)
        mTitle.textSize = 16f
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white))
        mTitle.text = getString(R.string.ConfirmOrder)
        toolbar.setBackgroundResource(R.color.blue)
        toolbar.setNavigationOnClickListener { finish() }
        return false
    }

    override fun setInflateId(): Int {
        return R.layout.activity_confirm_order
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
        initView()
    }

    private fun initView() {
        data.add(ConfirmOrderEntity())
        data.add(ConfirmOrderEntity())

        adapter = ConfirmOrderAdapter(data)
        adapter.emptyView = LayoutInflater.from(mContext).inflate(R.layout.view_empty, RelativeLayout(mContext), false)
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN)
        mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        mRecyclerView.adapter = adapter
        mRecyclerView.addItemDecoration(RecycleViewDivider(mContext, LinearLayoutManager.VERTICAL,
                10, ContextCompat.getColor(mContext, R.color.line_bg)))
    }

    @OnClick(R.id.ConfirmBuy)
    fun onViewClicked() {
        finish()
        Utils.startActivity(mContext, PayOrderActivity::class.java)
    }
}
