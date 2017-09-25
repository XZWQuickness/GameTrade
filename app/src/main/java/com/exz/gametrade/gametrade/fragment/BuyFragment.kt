package com.exz.gametrade.gametrade.fragment

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.activity.ConfirmOrderActivity
import com.exz.gametrade.gametrade.adapter.GamePropsAdapter
import com.exz.gametrade.gametrade.entity.GamePropsEntity
import com.exz.gametrade.gametrade.entity.PopScreenEntity
import com.exz.gametrade.gametrade.entity.PopSingleEntity
import com.exz.gametrade.gametrade.pop.PopFilter
import com.exz.gametrade.gametrade.pop.PopSingleList
import com.exz.gametrade.gametrade.utils.RecycleViewDivider
import com.szw.framelibrary.base.MyBaseFragment
import com.szw.framelibrary.utils.Utils
import kotlinx.android.synthetic.main.action_bar_old.*
import kotlinx.android.synthetic.main.fragment_buy.*
import kotlinx.android.synthetic.main.refresh_recycler.*
import razerdp.basepopup.BasePopupWindow
import java.util.*

/**
 * Created by pc on 2017/9/18.
 */

class BuyFragment : MyBaseFragment(), View.OnClickListener {
    internal var data: MutableList<GamePropsEntity> = ArrayList()
    lateinit var adapter: GamePropsAdapter
    lateinit var mPopSingleList: PopSingleList
    lateinit var mPopScreen: PopFilter
    internal var list: MutableList<PopSingleEntity> = ArrayList()
    internal var type = 0
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_buy, container, false)
        return rootView
    }

    override fun initView() {
        initToolbar()
        data.add(GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"))
        data.add(GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"))
        data.add(GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"))
        data.add(GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"))
        data.add(GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"))
        data.add(GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"))
        data.add(GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"))
        data.add(GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"))
        data.add(GamePropsEntity("通用紫宝石顶尖材料", "暗黑破坏-国服", "10.0", "100"))
        adapter = GamePropsAdapter(3, data)
        adapter.emptyView = LayoutInflater.from(context).inflate(R.layout.view_empty, RelativeLayout(context), false)
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(RecycleViewDivider(context, LinearLayoutManager.VERTICAL,
                1, ContextCompat.getColor(context, R.color.line_bg)))
        refresh.isEnabled = false
        mPopSingleList = PopSingleList(activity)
        mPopScreen = PopFilter(activity)
        rb1.setOnClickListener(this)
        rb2.setOnClickListener(this)
        rb3.setOnClickListener(this)
        mPopSingleList.onDismissListener = object : BasePopupWindow.OnDismissListener() {
            override fun onDismiss() {
                setDrawableBt(type)



            }
        }
        mPopScreen.onDismissListener=object :BasePopupWindow.OnDismissListener(){
            override fun onDismiss() {
//                setDrawableBt(type)

            }
        }
    }

    private fun setDrawableBt(type: Int) {

        when (type) {
            1 ->
                rb1.isChecked = false
            2 ->
                rb2.isChecked = false
            3 ->
                rb3.isChecked = false
        }
    }


    private fun initToolbar() {
        toolbar.setContentInsetsAbsolute(0, 0)
        toolbar.navigationContentDescription = null
        mTitle.textSize = 16f
        mTitle.setTextColor(ContextCompat.getColor(context, R.color.white))
        mTitle.text = "魔兽世界"
        mLeftImg.visibility = View.GONE
        mRight.textSize = 16f
        mRight.setTextColor(ContextCompat.getColor(context, R.color.white))
        mRight.text = getString(R.string.buy)
        toolbar.setBackgroundResource(R.color.blue)
        mRight.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.mRight//购买
            -> Utils.startActivity(context, ConfirmOrderActivity::class.java)
            R.id.rb1 -> {
                type = 1
                list.clear()
                list.add(PopSingleEntity("所有类型", true))
                list.add(PopSingleEntity("虚拟币类型", false))
                list.add(PopSingleEntity("装备道具类", false))
                mPopSingleList.setData(list)
                mPopSingleList.showPopupWindow(rb1)
            }
            R.id.rb2 -> {
                type = 2
                list.clear()
                list.add(PopSingleEntity("最新发布", true))
                list.add(PopSingleEntity("金额由低到高", false))
                list.add(PopSingleEntity("金额由高到低", false))
                mPopSingleList.setData(list)
                mPopSingleList.showPopupWindow(rb1)
            }
            R.id.rb3 -> {
                type = 3
                val list = ArrayList<PopScreenEntity>()
                list.add(PopScreenEntity(true))
                list.add(PopScreenEntity(false))
                list.add(PopScreenEntity(false))
                list.add(PopScreenEntity(false))
                list.add(PopScreenEntity(false))
                list.add(PopScreenEntity(false))
                list.add(PopScreenEntity(false))
                list.add(PopScreenEntity(false))
                list.add(PopScreenEntity(false))
                mPopScreen.setData(list)
                mPopScreen.showPopupWindow(rb1)
            }
        }
    }
}
