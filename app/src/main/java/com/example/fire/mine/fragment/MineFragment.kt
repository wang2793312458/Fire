package com.example.fire.mine.fragment

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fire.R
import com.example.fire.common.Api
import com.example.fire.common.CommonFragment
import com.example.fire.mine.fragment.MineContract.Present
import com.example.fire.mine.fragment.MineContract.View
import kotlinx.android.synthetic.main.fragment_mine.ivAvatar
import kotlinx.android.synthetic.main.fragment_mine.tvLevel
import kotlinx.android.synthetic.main.fragment_mine.tvName

class MineFragment : CommonFragment(), View {

  override lateinit var mPresent: Present

  override fun getContentViewLayoutId(): Int {
    return R.layout.fragment_mine
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

}