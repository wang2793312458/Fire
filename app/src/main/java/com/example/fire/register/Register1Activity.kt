package com.example.fire.register

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import com.example.fire.R
import com.example.fire.common.CommonActivity
import com.example.fire.common.Constants
import kotlinx.android.synthetic.main.activity_register1.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class Register1Activity : CommonActivity(), RegisterContract.View, OnClickListener {
    override fun onClick(p0: View?) {

    }

    override fun getActOrCtx(): Context {
        return this
    }

    override lateinit var mPresent: RegisterContract.Present
    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_register1
    }

    override fun initData(savedInstanceState: Bundle?) {
        RegisterPresent(this)
        tvCode.onClick {
            mPresent.getCode()
        }
        btnNext.onClick {
            mPresent.checkCode()
        }
    }

    override fun getPhone(): String {
        return etPhone.text.toString()
    }

    override fun getCode(): String = etCode.text.toString()

    override fun setCode(code: String) {
        tvCode.text = code
    }

    override fun getPassWord(): String {
        return ""
    }

    override fun getPassWordAgain(): String {
        return ""
    }

    override fun setIsClickable(b: Boolean) {
        tvCode.isClickable = b
    }

    override fun setIsSelected(b: Boolean) {
        tvCode.isSelected = b
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

    override fun jumpNext() {
        startActivity<Register2Activity>(
                Constants.INTENT_PHONE to etPhone.text.toString(),
                Constants.INTENT_CODE to etCode.text.toString()
        )
    }
}
