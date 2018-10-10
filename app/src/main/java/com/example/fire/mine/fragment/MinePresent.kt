package com.example.fire.mine.fragment

import android.annotation.SuppressLint
import com.example.fire.common.http.HttpFactory
import com.example.fire.mine.fragment.MineContract.Present
import com.example.fire.mine.fragment.MineContract.View

/**
 * @author by 王小智
 * Created on 2018/10/9.
 */
class MinePresent(private val mView: View) : Present {
  init {
    mView.mPresent = this
  }

  @SuppressLint("CheckResult")
  override fun start() {
    HttpFactory.getInstance()
        .getUserInfo(mapOf("userId" to "235"))
        .compose(HttpFactory.schedulers())
        .doOnSubscribe { }
        .doFinally { }
        .subscribe({
          mView.setName(it.name)
          mView.setHeadPic(it.headPic)
          mView.setSex(it.id)
        }, {
          mView.showMessage(it.message!!)
        })
  }
}