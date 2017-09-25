package com.exz.gametrade.gametrade.pop

import android.app.Activity
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.RelativeLayout
import butterknife.ButterKnife
import com.blankj.utilcode.util.ScreenUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.adapter.PopSingleAdapter
import com.exz.gametrade.gametrade.entity.PopSingleEntity
import com.exz.gametrade.gametrade.utils.RecycleViewDivider
import kotlinx.android.synthetic.main.activity_confirm_order.view.*
import razerdp.basepopup.BasePopupWindow

/**
 * Created by pc on 2017/9/19.
 */

class PopSingleList(context: Activity) : BasePopupWindow(context) {
    var adapter: PopSingleAdapter
    lateinit var v: View

    init {
        adapter = PopSingleAdapter()
        adapter.emptyView = LayoutInflater.from(getContext()).inflate(R.layout.view_empty, RelativeLayout(getContext()), false)
        adapter.setHeaderAndEmpty(true)
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN)
        v.mRecyclerView.layoutManager = LinearLayoutManager(getContext())
        v.mRecyclerView.adapter = adapter
        v.mRecyclerView.addItemDecoration(RecycleViewDivider(getContext(), LinearLayoutManager.VERTICAL,
                1, ContextCompat.getColor(getContext(), R.color.line_bg)))
        v.mRecyclerView.addOnItemTouchListener(object : OnItemClickListener() {
            override fun onSimpleItemClick(mAdapter: BaseQuickAdapter<*, *>?, view: View, position: Int) {
                for (PopSingleEntity in adapter.data) {
                    PopSingleEntity.isCheck = false
                }
                adapter.data[position].isCheck = true
                adapter.notifyDataSetChanged()

            }
        })
    }

    fun setData(lis: List<PopSingleEntity>) {
        adapter.setNewData(lis)
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
        v = View.inflate(context, R.layout.pop_list, null)
        ButterKnife.bind(this, v)
        return v
    }

    override fun initAnimaView(): View {
        return findViewById(R.id.mRecyclerView)
    }
}
