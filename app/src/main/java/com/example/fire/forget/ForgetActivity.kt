package com.example.fire.forget

import android.content.Context
import android.os.Bundle
import com.example.fire.R
import com.example.fire.common.CommonActivity
import com.example.fire.common.Constants
import kotlinx.android.synthetic.main.activity_forget.btnNext
import kotlinx.android.synthetic.main.activity_forget.etCode
import kotlinx.android.synthetic.main.activity_forget.etPhone
import kotlinx.android.synthetic.main.activity_forget.tvCode
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class ForgetActivity : CommonActivity(), ForgetContract.View {
  override lateinit var mPresent: ForgetContract.Present

  override fun getContentViewLayoutId(): Int {
    return R.layout.activity_forget
  }

  override fun initData(savedInstanceState: Bundle?) {
    ForgetPresent(this)
    tvCode.onClick {
      mPresent.getCode()
    }
    btnNext.onClick {
      mPresent.checkCode()
    }
  }

  override fun getActOrCtx(): Context {
    return this
  }

  override fun getPassWord(): String {
    return ""
  }

  override fun setIsClickable(b: Boolean) {
    tvCode.isClickable = b
  }

  override fun setIsSelected(b: Boolean) {
    tvCode.isSelected = b
  }

  override fun jumpNext() {
    startActivity<ResetActivity>(Constants.INTENT_PHONE to etPhone.text.toString())
  }

  override fun getPhone(): String {
    return etPhone.text.toString()
  }

  override fun getCode(): String {
    return etCode.text.toString()
  }

  override fun setCode(code: String) {
    tvCode.text = code
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
