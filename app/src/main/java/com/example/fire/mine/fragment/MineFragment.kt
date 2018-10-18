package com.example.fire.mine.fragment

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fire.R
import com.example.fire.common.Api
import com.example.fire.common.CommonFragment
import com.example.fire.mine.fragment.MineContract.Present
import com.example.fire.mine.fragment.MineContract.View
import com.example.fire.mine.setUp.SetUpActivity
import kotlinx.android.synthetic.main.fragment_mine.btnSet
import kotlinx.android.synthetic.main.fragment_mine.ivAvatar
import kotlinx.android.synthetic.main.fragment_mine.tvLevel
import kotlinx.android.synthetic.main.fragment_mine.tvName
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.support.v4.act
import org.jetbrains.anko.support.v4.startActivity

class MineFragment : CommonFragment(), View {

  override lateinit var mPresent: Present

  override fun getContentViewLayoutId(): Int {
    return R.layout.fragment_mine
    btnSet.onClick {
      startActivity<SetUpActivity>()
    }
  }

  override fun initData() {
    MinePresent(this)
    mPresent.start()
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

  override fun getContext(): Context {
    return act
  }
}