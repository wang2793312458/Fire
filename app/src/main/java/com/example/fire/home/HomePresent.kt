package com.example.fire.home

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.fire.common.Constants
import com.example.fire.common.http.HttpFactory
import com.example.fire.home.adapter.HomeKeyAdapter
import com.example.fire.home.adapter.HomeShopAdapter
import com.example.fire.utils.RecyclerViewUtil

/**
 * @author by 王小智
 * Created on 2018/10/19.
 */
class HomePresent(private val mView: HomeContract.View) : HomeContract.Present {
    private val mAdapter by lazy { HomeKeyAdapter() }
    private val mShopAdapter by lazy { HomeShopAdapter() }
    private var nowPage = 1

    init {
        mView.mPresent = this
    }

    @SuppressLint("CheckResult")
    override fun start() {
        HttpFactory.getInstance()
                .getHomePageType(mapOf("cityId" to "4", "nowPage" to "" + nowPage))
                .compose(HttpFactory.schedulers())
                .doOnSubscribe { }
                .doFinally { }
                .subscribe({
                    if (nowPage == 1) {
                        mAdapter.setList(it)
                    } else {
                        mAdapter.addList(it)
                    }
                }, {
                    mView.showMessage(it.message!!)
                })
        HttpFactory.getInstance().getHomeShopList(mapOf("cityId" to "4", "nowPage" to "" + nowPage,
                "lat" to "", "lng" to ""))
                .compose(HttpFactory.schedulers())
                .doOnSubscribe { }
                .doFinally { }
                .subscribe()
    }

    override fun attachRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(mView.getActOrCtx())
        recyclerView.adapter = mAdapter
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (RecyclerViewUtil.isScrollBottom(recyclerView) &&
                        recyclerView.adapter!!.itemCount % Constants.PAGE_SIZE == 0) {
                    nowPage++
                    start()
                }
            }
        })

    }
}