package com.exz.gametrade.gametrade.pop

import android.app.Activity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.EditText
import android.widget.RelativeLayout
import butterknife.ButterKnife
import com.blankj.utilcode.util.ScreenUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.adapter.PopScreenAdapter
import com.exz.gametrade.gametrade.entity.PopScreenEntity
import razerdp.basepopup.BasePopupWindow

/**
 * Created by pc on 2017/9/19.
 */

class PopFilter(context: Activity) : BasePopupWindow(context) {
    internal var adapter: PopScreenAdapter
    internal var mRecyclerView: RecyclerView
    internal var minPrice: EditText
    internal var highPrice: EditText

    init {
        adapter = PopScreenAdapter()
        mRecyclerView = findViewById(R.id.mRecyclerView) as RecyclerView
        minPrice = findViewById(R.id.minPrice) as EditText
        highPrice = findViewById(R.id.highPrice) as EditText
        adapter.emptyView = LayoutInflater.from(getContext()).inflate(R.layout.view_empty, RelativeLayout(getContext()), false)
        adapter.setHeaderAndEmpty(true)
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN)
        mRecyclerView.layoutManager = GridLayoutManager(getContext(), 3)
        mRecyclerView.adapter = adapter
    }

    fun setData(list: List<PopScreenEntity>) {
        adapter.setNewData(list)
    }

    override fun initShowAnimation(): Animation {
        val shakeAnimate = TranslateAnimation(0f, 0f, -ScreenUtils.getScreenHeight().toFloat(), 0f)
        shakeAnimate.duration = 400
        return shakeAnimate
    }

    override fun initExitAnimation(): Animation {
        val shakeAnimate = TranslateAnimation(0f, ScreenUtils.getScreenWidth().toFloat(), 0f, 0f)
        shakeAnimate.duration = 400
        return shakeAnimate
    }


    override fun getClickToDismissView(): View {
        return popupWindowView
    }

    override fun onCreatePopupView(): View {
        val inflate = View.inflate(context, R.layout.pop_filter, null)
        ButterKnife.bind(this, inflate)
        return inflate
    }

    override fun initAnimaView(): View {
        return findViewById(R.id.llLay)
    }
}
