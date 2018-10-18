package com.example.fire.mine.setUp

import android.content.Context
import android.os.Bundle
import com.example.fire.R
import com.example.fire.common.ActivityCollector
import com.example.fire.common.CommonActivity
import com.example.fire.common.Constants
import com.example.fire.common.WebViewActivity
import com.example.fire.login.LoginActivity
import com.example.fire.mine.feedBack.FeedbackActivity
import kotlinx.android.synthetic.main.activity_set_up.btnAbout
import kotlinx.android.synthetic.main.activity_set_up.btnClear
import kotlinx.android.synthetic.main.activity_set_up.btnContacts
import kotlinx.android.synthetic.main.activity_set_up.btnExit
import kotlinx.android.synthetic.main.activity_set_up.btnFeedback
import kotlinx.android.synthetic.main.activity_set_up.btnUpgrade
import org.jetbrains.anko.act
import org.jetbrains.anko.alert
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.cancelButton
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SetUpActivity : CommonActivity(), SetUpContract.View {
  override lateinit var mPresent: SetUpContract.Present

  private var mUrl: String? = null
  private var servicePhone: String? = null
  override fun getContentViewLayoutId(): Int {
    return R.layout.activity_set_up
  }

  override fun initData(savedInstanceState: Bundle?) {
    SetUpPresent(this)
    mPresent.start()
    btnAbout.onClick {
            mUrl?.let {
      startActivity<WebViewActivity>(
          Constants.INTENT_WEB_VIEW_TITLE to "关于我们",
          Constants.INTENT_WEB_URL to mUrl
      )
      }
    }
    btnClear.onClick {
      toast(R.string.tips_clear_success)
//            ToolsUtil.clearAllCache(getActivity(), getString(R.string.tips_clear_success))
    }
    btnContacts.onClick {
      servicePhone?.let { makeCall(servicePhone!!) }
    }
    btnExit.onClick {
      exit()
    }
    btnFeedback.onClick {
      startActivity<FeedbackActivity>()
    }
    btnUpgrade.onClick {
      mPresent.upgrade()
    }
  }

  override fun showMessage(var1: String) {

  }

  override fun showMessage(var1: Int) {
  }

  override fun showProgress() {
  }

  override fun hideProgress() {
  }

  override fun getActOrCtx(): Context {
    return act
  }

  override fun setWebUrl(url: String) {
    mUrl = url
  }

  override fun setPhone(phone: String) {
    servicePhone = phone
  }

  private fun exit() {
    alert(Appcompat, R.string.tips_sure_exit, R.string.exit) {
      okButton {
        startActivity<LoginActivity>()
        ActivityCollector.finishAll()
        System.exit(0)
      }
      cancelButton {
      }
    }.show()
  }
}
