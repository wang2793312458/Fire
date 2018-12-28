package com.example.fire.mine.address.list

import android.annotation.SuppressLint
import com.example.fire.common.http.HttpFactory
import com.example.fire.mine.address.list.adapter.MineAddressListAdapter
import com.example.fire.mine.address.list.adapter.MineAddressListAdapter.onKotlinItemClickListener

/**
 * @author by 王小智
 * Created on 2018/10/19.
 */
class MineAddressListPresent(private val mView: MineAddressListContract.View) : MineAddressListContract.Present {
    private val mAdapter by lazy { MineAddressListAdapter() }
    private var nowPage = 1

    init {
        mView.mPresent = this
    }

    @SuppressLint("CheckResult")
    override fun start() {
        HttpFactory.getInstance()
                .getAddressList(mapOf("userId" to "235"))
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
    }

    override fun attachRecyclerView(recyclerView: androidx.recyclerview.widget.RecyclerView) {
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(mView.getActOrCtx())
        recyclerView.adapter = mAdapter
        mAdapter.setOnItemClickListener(object : onKotlinItemClickListener {
            override fun delete(position: Int) {

            }
        })
    }
}