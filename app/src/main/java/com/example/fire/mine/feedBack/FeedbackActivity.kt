package com.example.fire.mine.feedBack

import android.content.Context
import android.os.Bundle
import com.example.fire.R
import com.example.fire.common.CommonActivity
import kotlinx.android.synthetic.main.activity_feedback.btnSubmit
import kotlinx.android.synthetic.main.activity_feedback.etContent
import org.jetbrains.anko.sdk25.coroutines.onClick

class FeedbackActivity : CommonActivity(), FeedBackContract.View {

  override lateinit var mPresent: FeedBackContract.Present

  override fun getContentViewLayoutId(): Int {
    return R.layout.activity_feedback
  }

  override fun initData(savedInstanceState: Bundle?) {
    FeedBackPresent(this)
    btnSubmit.onClick {
      mPresent.feedback()
    }
  }

  override fun getContent(): String {
    return etContent.text.toString()
  }

  override fun getActOrCtx(): Context {
    return this
  }

  override fun showMessage(var1: String) {

  }

  override fun showMessage(var1: Int) {

  }

  override fun showProgress() {

  }

  override fun hideProgress() {

  }
}
