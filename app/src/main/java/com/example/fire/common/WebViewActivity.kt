package com.example.fire.common

import android.annotation.SuppressLint
import android.os.Bundle
import com.example.fire.R
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : CommonActivity() {
    private var url: String? = null
    private var title: String? = null
    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_web_view
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initData(savedInstanceState: Bundle?) {
        url = intent.getStringExtra(Constants.INTENT_WEB_URL)
        title = intent.getStringExtra(Constants.INTENT_WEB_VIEW_TITLE)
        tvTitle.text = title
        web.settings.useWideViewPort = true
        web.settings.loadWithOverviewMode = true
        web.settings.javaScriptEnabled = true
        web.loadUrl(url)
    }
}
