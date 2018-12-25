package com.example.fire.message

import android.content.Context
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
import com.example.fire.R
import com.example.fire.common.CommonFragment
import kotlinx.android.synthetic.main.include_recycle_refresh.*
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.toast

class MessageFragment : CommonFragment(), MessageContract.View, OnRefreshListener {
    override lateinit var mPresent: MessageContract.Present

    override fun getContentViewLayoutId(): Int {
        return R.layout.fragment_message
    }

    override fun initData() {
        MessagePresent(this)
        mPresent.start()
        mPresent.attachRecyclerView(rvList)
        srRefresh.setColorSchemeResources(R.color.colorPrimary)
        srRefresh.setOnRefreshListener(this)
    }

    override fun showMessage(var1: String) {
        toast(var1)
    }

    override fun showMessage(var1: Int) {
        toast(var1)
    }

    override fun showProgress() {
        srRefresh?.isRefreshing = true
    }

    override fun hideProgress() {
        srRefresh?.isRefreshing = false
    }

    override fun onRefresh() {
        mPresent.refresh()
    }

    override fun getActOrCtx(): Context {
        return ctx
    }
}