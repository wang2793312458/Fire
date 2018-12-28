package com.example.fire.mine.setUp

import android.annotation.SuppressLint
import com.example.fire.common.http.HttpFactory

/**
 * @author by 王小智
 * Created on 2018/10/18.
 */
class SetUpPresent(private val mView: SetUpContract.View) : SetUpContract.Present {
    init {
        mView.mPresent = this
    }

    @SuppressLint("CheckResult")
    override fun start() {
        HttpFactory.getInstance()
                .getAboutUS(mapOf("id" to "5"))
                .compose(HttpFactory.schedulers())
                .doOnSubscribe { }
                .doFinally { }
                .subscribe({
                    mView.setWebUrl(it.link + "74")
                }, {
                    mView.showMessage(it.message!!)
                })
        HttpFactory.getInstance()
                .getMobiles(mapOf())
                .compose(HttpFactory.schedulers())
                .doOnSubscribe { }
                .doFinally { }
                .subscribe({
                    mView.setPhone(it.value)
                }, {
                    mView.showMessage(it.message!!)
                })
    }

    @SuppressLint("CheckResult")
    override fun upgrade() {
        HttpFactory.getInstance()
                .upgrade(mapOf())
                .compose(HttpFactory.schedulers())
                .doOnSubscribe { }
                .doFinally { }
                .subscribe({

                }, {
                    mView.showMessage(it.message!!)
                })
    }
}