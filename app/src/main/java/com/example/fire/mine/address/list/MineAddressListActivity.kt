package com.example.fire.mine.address.list

import android.content.Context
import android.os.Bundle
import com.example.fire.R
import com.example.fire.common.CommonActivity
import org.jetbrains.anko.act

class MineAddressListActivity : CommonActivity(), MineAddressListContract.View {
    override lateinit var mPresent: MineAddressListContract.Present
    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_mine_address_list
    }

    override fun initData(savedInstanceState: Bundle?) {
        MineAddressListPresent(this)
        mPresent.start()
    }

    override fun showMessage(var1: String) {

    }

    override fun showMessage(var1: Int) {
    }

    override fun showProgress() {
    }

    override fun hideProgress() {
    }

    override fun getActOrCtx(): Context {
        return act
    }
}
