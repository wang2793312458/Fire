package com.example.fire.mine.fragment

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fire.R
import com.example.fire.common.Api
import com.example.fire.common.CommonFragment
import com.example.fire.mine.setUp.SetUpActivity
import kotlinx.android.synthetic.main.fragment_mine.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.ctx
import org.jetbrains.anko.support.v4.startActivity

class MineFragment : CommonFragment(), MineContract.View {

    override lateinit var mPresent: MineContract.Present

    override fun getContentViewLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initData() {
        MinePresent(this)
        mPresent.start()
        btnSet.onClick {
            startActivity<SetUpActivity>()
        }
    }

    override fun setName(name: String) {
        tvName.text = name
    }

    override fun setHeadPic(headPic: String) {
        Glide.with(this)
                .load(Api.API_LOAD_IMAGE + headPic)
                .apply(RequestOptions().centerCrop())
                .into(ivAvatar)
    }

    override fun setSex(id: Int) {
        tvLevel.text = id.toString()
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
        return ctx
    }
}