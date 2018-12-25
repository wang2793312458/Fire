package com.example.fire.mine.feedBack

import android.annotation.SuppressLint
import com.example.fire.R
import com.example.fire.common.http.HttpFactory

/**
 * @author by 王小智
 * Created on 2018/10/18.
 */
class FeedBackPresent(private val mView: FeedBackContract.View) : FeedBackContract.Present {

    override fun start() {
    }

    init {
        mView.mPresent = this
    }

    @SuppressLint("CheckResult")
    override fun feedback() {
        if (mView.getContent().isEmpty()) {
            mView.showMessage(R.string.tips_please_input_feedback_content)
            return
        }
        HttpFactory.getInstance()
                .getFeedback(mapOf("content" to mView.getContent()))
                .compose(HttpFactory.schedulers())
                .doOnSubscribe { }
                .doFinally { }
                .subscribe({
                    if (it) {
                        mView.showMessage(R.string.tips_submit_success)
//            mView.getActOrCtx()
//                .finish()
                    } else {
                        mView.showMessage(R.string.tips_submit_failed)
                    }
                }, {
                    mView.showMessage(it.message!!)
                })
    }

}