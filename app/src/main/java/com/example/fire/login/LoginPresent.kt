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

    @SuppressLint("CheckResult") //该注解意味着需要对方法的返回值进行处理
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
                .doOnSubscribe { mView.showProgress() }
                .doFinally { mView.hideProgress() }
                .subscribe({
                    mView.showMessage(R.string.tips_success_login)
                    mView.jumpMainActivity()
                }, {
                    mView.showMessage(it.message!!)
                })
    }
}