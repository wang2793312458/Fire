package com.example.fire.mine.info

import android.content.Context
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fire.R
import com.example.fire.common.Api
import com.example.fire.common.CommonActivity
import kotlinx.android.synthetic.main.activity_mine_info.*

class MineInfoActivity : CommonActivity(), MeInfoContract.View {

    override lateinit var mPresent: MeInfoContract.Present

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_mine_info
    }

    override fun initData(savedInstanceState: Bundle?) {
        MeInfoPresent(this)
        mPresent.start()
    }

    override fun setName(name: String) {
        tvName.text = name
    }

    override fun setHeadPic(headPic: String) {
        Glide.with(this)
                .load(Api.API_LOAD_IMAGE + headPic)
                .apply(RequestOptions().centerCrop().error(R.mipmap.tab_icon_mine_default)
                        .placeholder(R.mipmap.tab_icon_mine_default))
                .into(ivAvatar)
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
        return this
    }

}
