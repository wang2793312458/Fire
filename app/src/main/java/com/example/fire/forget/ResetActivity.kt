package com.example.fire.forget

import android.content.Context
import android.os.Bundle
import com.example.fire.R
import com.example.fire.common.CommonActivity
import com.example.fire.common.Constants
import com.example.fire.login.LoginActivity
import kotlinx.android.synthetic.main.activity_reset.btnComplete
import kotlinx.android.synthetic.main.activity_reset.etPassword
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ResetActivity : CommonActivity(), ForgetContract.View {
  private var phone: String = ""
  override lateinit var mPresent: ForgetContract.Present
  override fun getContentViewLayoutId(): Int {
    return R.layout.activity_reset
  }

  override fun initData(savedInstanceState: Bundle?) {
    ForgetPresent(this)
    phone = intent.getStringExtra(Constants.INTENT_PHONE)
    btnComplete.onClick {
      mPresent.getForeignPwd()
    }
  }

  override fun getActOrCtx(): Context {
    return this
  }

  override fun getPassWord(): String {
    return etPassword.text.toString()
  }

  override fun getPhone(): String {
    return phone
  }

  override fun getCode(): String {
    return ""
  }

  override fun setCode(code: String) {

  }

  override fun setIsClickable(b: Boolean) {

  }

  override fun setIsSelected(b: Boolean) {

  }

  override fun jumpNext() {
    startActivity<LoginActivity>()
  }

  override fun showMessage(var1: String) {
    toast(var1)
  }

  override fun showMessage(var1: Int) {
    toast(var1)
  }

  override fun showProgress() {

  }

  override fun hideProgress() {

  }
}
