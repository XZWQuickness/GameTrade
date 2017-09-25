package com.exz.gametrade.gametrade.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.RelativeLayout
import butterknife.ButterKnife
import com.bigkoo.pickerview.OptionsPickerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.adapter.PostSaleAdapter
import com.exz.gametrade.gametrade.entity.PostSaleEntity
import com.exz.gametrade.gametrade.listener.OnNumListener
import com.exz.gametrade.gametrade.utils.DialogUtils
import com.exz.gametrade.gametrade.utils.RecycleViewDivider
import com.szw.framelibrary.base.BaseActivity
import kotlinx.android.synthetic.main.action_bar_old.*
import kotlinx.android.synthetic.main.activity_post_sale.*
import kotlinx.android.synthetic.main.lay_post_sale_healad.view.*
import org.jetbrains.anko.toast
import java.util.*

/**
 * Created by pc on 2017/9/18.
 * 发布寄售
 */

class PostSaleActivity : BaseActivity(), View.OnClickListener, OnNumListener {


    lateinit var adapter: PostSaleAdapter
    internal var data: MutableList<PostSaleEntity> = ArrayList()
    lateinit var mo: OptionsPickerView<String>;
    lateinit var goodsTypeList: ArrayList<String>
    override fun initToolbar(): Boolean {
        toolbar.setContentInsetsAbsolute(0, 0)
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white)
        mTitle.textSize = 16f
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white))
        mTitle.text = getString(R.string.Post_sale)
        toolbar.setBackgroundResource(R.color.blue)
        toolbar.setNavigationOnClickListener { finish() }
        return false
    }

    override fun setInflateId(): Int {
        return R.layout.activity_post_sale
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
        data.add(PostSaleEntity())
        data.add(PostSaleEntity())
        data.add(PostSaleEntity())
        adapter = PostSaleAdapter(data)
        val headView = LayoutInflater.from(mContext).inflate(R.layout.lay_post_sale_healad, null)
        adapter.addHeaderView(headView)
        adapter.emptyView = LayoutInflater.from(mContext).inflate(R.layout.view_empty, RelativeLayout(mContext), false)
        adapter.setHeaderAndEmpty(true)
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN)
        mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        mRecyclerView.adapter = adapter
        mRecyclerView.addItemDecoration(RecycleViewDivider(mContext, LinearLayoutManager.VERTICAL,
                10, ContextCompat.getColor(mContext, R.color.line_bg)))
        mo = OptionsPickerView(mContext);
        goodsTypeList = ArrayList();
        goodsTypeList.add("虚拟货币")
        goodsTypeList.add("装备道具类")
        mo.setPicker(goodsTypeList)
        mo.setCyclic(false)
        mo.setOnoptionsSelectListener { options1, option2, options3 ->
            headView.goodsType.setText(goodsTypeList[options1])
        }
        headView.goodsType.setOnClickListener(this)
        mRecyclerView.addOnItemTouchListener(object : OnItemChildClickListener() {
            override fun onSimpleItemChildClick(mAdapter: BaseQuickAdapter<*, *>?, view: View, position: Int) {
                when (view.id) {
                    R.id.input ->
                        DialogUtils.ChangeNum(mContext, 1, this@PostSaleActivity)
                    R.id.title -> {
                        for (PostSaleEntity in adapter.data) {
                            PostSaleEntity.isCheck = false
                        }
                        adapter.data.get(position).isCheck = true
                        adapter.notifyDataSetChanged()
                    }
                }
            }
        })
    }

    override fun onNum(var1: Int) {
        mContext.toast("${var1}" + "")
    }

    companion object {
        var inventory = 200
        var currentCount = 0
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.goodsType ->
                mo.show()
            R.id.release ->
                finish()
        }
    }

}
