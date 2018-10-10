package com.example.fire.forget

import android.annotation.SuppressLint
import android.os.CountDownTimer
import com.example.fire.R
import com.example.fire.common.http.HttpFactory

/**
 * @author by 王小智
 * Created on 2018/10/10.
 */
class ForgetPresent(private val mView: ForgetContract.View) : ForgetContract.Present {

  private var isGet = false
  private var timeDown: CountDownTimer

  init {
    mView.mPresent = this
    timeDown = object : CountDownTimer(60 * 1000, 1000) {
      @SuppressLint("SetTextI18n")
      override fun onTick(millisUntilFinished: Long) {
        mView.setIsClickable(false)
        mView.setIsSelected(true)
        mView.setCode(
            mView.getContext().getString(R.string.get_code_time, millisUntilFinished / 1000)
        )
      }

      override fun onFinish() {
        mView.setIsClickable(true)
        mView.setIsSelected(false)
        mView.setCode(R.string.get_verify.toString())
      }
    }
  }

  override fun start() {

  }

  @SuppressLint("CheckResult")
  override fun getCode() {
    if (mView.getPhone().isEmpty()) {
      mView.showMessage(R.string.tips_please_input_phone)
      return
    }
    isGet = true
    HttpFactory.getInstance()
        .getForeignPwdCode(mapOf("phone" to mView.getPhone()))
        .compose(HttpFactory.schedulers())
        .doOnSubscribe { }
        .doFinally { }
        .subscribe({
          if (it) {
            mView.showMessage(R.string.tips_get_success)
            timeDown.start()
          } else {
            mView.showMessage(R.string.tips_get_failed)
          }
        }, {
          mView.showMessage(it.message!!)
        })
  }

  @SuppressLint("CheckResult")
  override fun checkCode() {
    if (mView.getPhone().isEmpty()) {
      mView.showMessage(R.string.tips_please_input_phone)
      return
    }
    if (!isGet) {
      mView.showMessage(R.string.hint_please_get_code)
      return
    }
    if (mView.getCode().isEmpty()) {
      mView.showMessage(R.string.tips_please_input_short_sms)
      return
    }
    HttpFactory.getInstance()
        .getCheckForeignPwdCode(mapOf("phone" to mView.getPhone(), "code" to mView.getCode()))
        .compose(HttpFactory.schedulers())
        .doOnSubscribe { }
        .doFinally { }
        .subscribe({
          if (it) {
            mView.showMessage(R.string.tips_please_set_password)
            mView.jumpNext()
          } else {
            mView.showMessage(R.string.tips_verify_failed)
          }
        }, {
          mView.showMessage(it.message!!)
        })
  }

  @SuppressLint("CheckResult")
  override fun getForeignPwd() {
    if (mView.getPassWord().isEmpty()) {
      mView.showMessage(R.string.tips_please_set_password)
      return
    }
    if (mView.getPassWord().length < 6) {
      mView.showMessage(R.string.tips_password_length_error)
      return
    }
    HttpFactory.getInstance()
        .getForeignPwd(mapOf("userName" to mView.getPhone(), "pwd" to mView.getPassWord()))
        .compose(HttpFactory.schedulers())
        .doOnSubscribe { }
        .doFinally { }
        .subscribe({
          if (it) {
            mView.jumpNext()
            mView.showMessage(R.string.tips_modify_success)
          } else {
            mView.showMessage(R.string.tips_modify_failed)
          }
        }, {
          mView.showMessage(it.message!!)
        })
  }
}