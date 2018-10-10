package com.example.fire.mine.setUp

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
import org.jetbrains.anko.alert
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.cancelButton
import org.jetbrains.anko.makeCall
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SetUpActivity : CommonActivity() {

  private var url: String? = null
  private var servicePhone: String? = null
  override fun getContentViewLayoutId(): Int {
    return R.layout.activity_set_up
  }

  override fun initData(savedInstanceState: Bundle?) {
    getAboutUS()
    btnAbout.onClick {
      url?.let {
        startActivity<WebViewActivity>(
            Constants.INTENT_WEB_VIEW_TITLE to "关于我们",
            Constants.INTENT_WEB_URL to it
        )
      }
    }
    btnClear.onClick {
      toast(R.string.tips_clear_success)
//            ToolsUtil.clearAllCache(getActivity(), getString(R.string.tips_clear_success))
    }
    btnContacts.onClick {
      servicePhone?.let { makeCall(it) }
    }
    btnExit.onClick {
      exit()
    }
    btnFeedback.onClick {
      startActivity<FeedbackActivity>()
    }
    btnUpgrade.onClick {
      upgrade()
    }
  }

  private fun getAboutUS() {
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

  private fun upgrade() {
  }
}
