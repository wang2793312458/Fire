package com.example.fire.login

import android.annotation.SuppressLint
import com.example.fire.R
import com.example.fire.common.http.HttpFactory

/**
 * @author by 王小智
 * Created on 2018/10/8.
 */
class LoginPresent(private val mView: LoginContract.View) : LoginContract.Present {

  init {
    mView.mPresent = this
  }

  override fun start() {
  }

  @SuppressLint("CheckResult")
  override fun login() {
    if (mView.getPhone().isEmpty()) {
      mView.showMessage(R.string.tips_please_input_phone)
      return
    }
    if (mView.getPwd().isEmpty()) {
      mView.showMessage(R.string.tips_please_input_password)
      return
    }
    HttpFactory.getInstance()
        .login(mapOf("phone" to mView.getPhone(), "password" to mView.getPwd(), "type" to "1"))
        .compose(HttpFactory.schedulers())
        .doOnSubscribe { }
        .doFinally { }
        .subscribe({
          mView.showMessage(R.string.tips_success_login)
          mView.jumpMainActivity()
        }, {
          mView.showMessage(it.message!!)
        })

//    HttpFactory.getInstance()      todo   调用这个接口   需要把HttpFactory   第22行的url更换
//        .getGankData("福利", "10", "20")
//        .compose(HttpFactory.schedulers())
//        .doOnSubscribe { }
//        .doFinally { }
//        .subscribe({
//
//        })

  }
}