package com.example.fire.register

import android.content.Context
import android.os.Bundle
import com.example.fire.R
import com.example.fire.common.CommonActivity
import com.example.fire.common.Constants
import com.example.fire.common.http.setShowOrHidePassword
import com.example.fire.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register2.*
import org.jetbrains.anko.sdk25.coroutines.onCheckedChange
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class Register2Activity : CommonActivity(), RegisterContract.View {
    private var phone: String = ""
    private var code: String = ""
    override lateinit var mPresent: RegisterContract.Present
    override fun getActOrCtx(): Context {
        return this
    }

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_register2
    }

    override fun initData(savedInstanceState: Bundle?) {
        RegisterPresent(this)
        phone = intent.getStringExtra(Constants.INTENT_PHONE)
        code = intent.getStringExtra(Constants.INTENT_CODE)

        btnRegister.onClick {
            mPresent.getRegister()
        }
        cbPassword.onCheckedChange { _, isChecked ->
            etPassword.setShowOrHidePassword(isChecked)
        }
    }

    override fun getPhone(): String = phone

    override fun getCode(): String = code

    override fun setCode(code: String) {
    }

    override fun getPassWord(): String = etPassword.text.toString()

    override fun getPassWordAgain(): String = etPasswordAgain.text.toString()

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

    override fun setIsClickable(b: Boolean) {}

    override fun setIsSelected(b: Boolean) {}

    override fun jumpNext() {
        startActivity<LoginActivity>()
    }
}
