package com.example.fire.home

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.fire.common.Constants
import com.example.fire.common.http.HttpFactory
import com.example.fire.home.adapter.HomeKeyAdapter
import com.example.fire.utils.RecyclerViewUtil

/**
 * @author by 王小智
 * Created on 2018/10/19.
 */
class HomePresent(private val mView: HomeContract.View) : HomeContract.Present {
    private val mAdapter by lazy { HomeKeyAdapter() }

    init {
        mView.mPresent = this
    }

    @SuppressLint("CheckResult")
    override fun start() {
        HttpFactory.getInstance()
                .getHomePageType(mapOf("cityId" to "4", "nowPage" to "1"))
                .compose(HttpFactory.schedulers())
                .doOnSubscribe { }
                .doFinally { }
                .subscribe({
                    mAdapter.setList(it)
                }, {
                    mView.showMessage(it.message!!)
                })
    }

    override fun attachRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(mView.getActOrCtx())
        recyclerView.adapter = mAdapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (RecyclerViewUtil.isScrollBottom(recyclerView) &&
                        recyclerView.adapter!!.itemCount % Constants.PAGE_SIZE == 0) {
//                    getMsgList()
                }
            }
        })

    }
}