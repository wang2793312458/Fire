package com.example.fire.login

import android.content.Context
import android.os.Bundle
import com.example.fire.R
import com.example.fire.common.CommonActivity
import com.example.fire.common.MainActivity
import com.example.fire.common.http.setShowOrHidePassword
import com.example.fire.forget.ForgetActivity
import com.example.fire.register.Register1Activity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.sdk27.coroutines.onCheckedChange
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : CommonActivity(), LoginContract.View {
    override fun getActOrCtx(): Context {
        return this
    }

    override lateinit var mPresent: LoginContract.Present
    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initData(savedInstanceState: Bundle?) {
        LoginPresent(this)
        mPresent.start()
        button_login.onClick {
            mPresent.login()
        }
        button_register.onClick {
            startActivity<Register1Activity>()
        }
        cbPassword.onCheckedChange { _, isChecked ->
            etPassword.setShowOrHidePassword(isChecked)
        }
        button_forget.onClick {
            startActivity<ForgetActivity>()
        }
    }

    override fun showMessage(var1: String) {
        toast(var1)
    }

    override fun showMessage(var1: Int) {
        toast(var1)
    }

    override fun showProgress() {
        showLoading()
    }

    override fun hideProgress() {
        showContent()
    }

    override fun getPhone(): String {
        return etPhone.text.toString()
    }

    override fun getPwd(): String {
        return etPassword.text.toString()
    }

    override fun jumpMainActivity() {
        startActivity<MainActivity>()
        finish()
    }
}
