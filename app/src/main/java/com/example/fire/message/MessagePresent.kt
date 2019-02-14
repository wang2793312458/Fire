package com.example.fire.message

import android.annotation.SuppressLint
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fire.common.Constants
import com.example.fire.common.http.HttpFactory
import com.example.fire.message.adapter.MessageAdapter
import com.example.fire.utils.RecyclerViewUtil

class MessagePresent(private val mView: MessageContract.View) : MessageContract.Present {
    private val mAdapter by lazy { MessageAdapter() }
    private var nowPage = 1

    init {
        mView.mPresent = this
    }

    override fun attachRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(mView.getActOrCtx())
        recyclerView.adapter = mAdapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView:RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (RecyclerViewUtil.isScrollBottom(recyclerView) &&
                        recyclerView.adapter!!.itemCount % Constants.PAGE_SIZE == 0) {
                    nowPage++
                    getMsgList()
                }
            }
        })
    }

    override fun refresh() {
        nowPage = 1
        getMsgList()
    }

    override fun start() {
        getMsgList()
    }

    @SuppressLint("CheckResult")
    private fun getMsgList() {
        HttpFactory.getInstance()
                .getMsg(mapOf("userId" to "235", "nowPage" to nowPage.toString()))
                .compose(HttpFactory.schedulers())
                .doOnSubscribe { mView.showProgress() }
                .doFinally { mView.hideProgress() }
                .subscribe({
                    if (nowPage == 1) {
                        mAdapter.setList(it)
                    } else {
                        mAdapter.addList(it)
                    }
                }, {
                    mView.showMessage(it.message!!)
                })

    }
}
