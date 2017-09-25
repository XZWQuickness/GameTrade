package com.exz.gametrade.gametrade.activity

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.widget.RelativeLayout
import butterknife.ButterKnife
import butterknife.OnClick
import com.blankj.utilcode.util.EncryptUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.exz.gametrade.gametrade.R
import com.exz.gametrade.gametrade.adapter.MsgAdapter
import com.exz.gametrade.gametrade.appclication.App
import com.exz.gametrade.gametrade.config.Constants
import com.exz.gametrade.gametrade.config.Urls
import com.exz.gametrade.gametrade.entity.MessageEntity
import com.exz.gametrade.gametrade.utils.RecycleViewDivider
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.szw.framelibrary.app.MyApplication.Companion.salt
import com.szw.framelibrary.base.BaseActivity
import com.szw.framelibrary.utils.net.NetEntity
import com.szw.framelibrary.utils.net.callback.JsonCallback
import kotlinx.android.synthetic.main.action_bar_old.*
import kotlinx.android.synthetic.main.refresh_recycler.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by pc on 2017/9/21.
 * 消息列表
 */

class MsgListActivity : BaseActivity(), SwipeRefreshLayout.OnRefreshListener, BaseQuickAdapter.RequestLoadMoreListener {
    lateinit var adapter: MsgAdapter<MessageEntity>
    internal var list: MutableList<MessageEntity> = ArrayList()
    internal var page = 1
    private var refreshState = Constants.RefreshState.STATE_REFRESH
    override fun initToolbar(): Boolean {
        toolbar.setContentInsetsAbsolute(0, 0)
        toolbar.setNavigationIcon(R.mipmap.icon_back_left_white)
        mTitle.textSize = 16f
        mTitle.setTextColor(ContextCompat.getColor(mContext, R.color.white))
        mTitle.text = getString(R.string.Message)
        toolbar.setBackgroundResource(R.color.blue)
        toolbar.setNavigationOnClickListener { finish() }
        return false
    }

    override fun setInflateId(): Int {
        return R.layout.activity_msg_list
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ButterKnife.bind(this)
        initView()
    }

    private fun initView() {
        list.add(MessageEntity())
        list.add(MessageEntity())
        list.add(MessageEntity())
        list.add(MessageEntity())
        list.add(MessageEntity())
        adapter = MsgAdapter()
        adapter.emptyView = LayoutInflater.from(mContext).inflate(R.layout.view_empty, RelativeLayout(mContext), false)
        adapter.setHeaderAndEmpty(true)
        adapter.setNewData(list)
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN)
        recyclerView.layoutManager = LinearLayoutManager(mContext)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(RecycleViewDivider(mContext, LinearLayoutManager.VERTICAL,
                1, ContextCompat.getColor(mContext, R.color.line_bg)))
        refresh.setOnRefreshListener(this)
        adapter.setOnLoadMoreListener(this, recyclerView)
        onRefresh()
    }

    private fun initData() {
        val timestamp = System.currentTimeMillis()
        val map = HashMap<String, String>()
        map.put("id", App.getLoginUserId())
        map.put("timestamp", timestamp.toString() + "")
        map.put("page", page.toString() + "")
        map.put("requestCheck", EncryptUtils.encryptMD5ToString(App.getLoginUserId() + timestamp,
                salt).toLowerCase())
        OkGo.post<NetEntity<List<MessageEntity>>>(Urls.url).params(map).tag(this).execute(object : JsonCallback<NetEntity<List<MessageEntity>>>() {
            override fun onSuccess(response: Response<NetEntity<List<MessageEntity>>>) {
                try {
                    refresh.isEnabled = true
                    refresh.isRefreshing = false
                } catch (e: Exception) {
                }
                if (response.body().getCode() == Constants.NetCode.SUCCESS) {
                    if (refreshState == Constants.RefreshState.STATE_REFRESH) {
                        val list=response.body().data;
                        adapter.setNewData(list)
                    } else {
                        adapter.addData(response.body().data as List<MessageEntity>)

                    }
                    if (response.body().data?.isNotEmpty()==true) {
                        adapter.loadMoreComplete()
                        page++
                    } else {
                        adapter.loadMoreEnd()
                    }
                }
            }

            override fun onError(response: Response<NetEntity<List<MessageEntity>>>) {
                super.onError(response)
                refresh.isRefreshing = false
                adapter.loadMoreEnd()
            }
        })


    }

    @OnClick(R.id.mLeftImg)
    fun onViewClicked() {
        finish()
    }

    override fun onRefresh() {
        page = 1
        refreshState = Constants.RefreshState.STATE_REFRESH
        initData()

    }


    override fun onLoadMoreRequested() {
        page++
        refreshState = Constants.RefreshState.STATE_LOAD_MORE
        initData()
    }
}
