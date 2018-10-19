package com.example.fire.mine.info

import android.annotation.SuppressLint
import com.example.fire.common.http.HttpFactory

/**
 * @author by 王小智
 * Created on 2018/10/19.
 */
class MeInfoPresent(private val mView: MeInfoContract.View) : MeInfoContract.Present {

  init {
    mView.mPresent = this
  }

  @SuppressLint("CheckResult")
  override fun start() {
    HttpFactory.getInstance()
        .getUserInfoDetail(mapOf("userId" to "235"))
        .compose(HttpFactory.schedulers())
        .doOnSubscribe { mView.showProgress() }
        .doFinally { mView.hideProgress() }
        .subscribe({
          mView.setName(it.name)
          mView.setHeadPic(it.headPic)
        }, {
          mView.showMessage(it.message!!)
        })
  }
}