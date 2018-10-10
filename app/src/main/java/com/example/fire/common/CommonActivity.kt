package com.example.fire.common

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.view.View

@SuppressLint("Registered")
abstract class CommonActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData(savedInstanceState)
    }

    /**
     * 获取当前布局id
     */
    abstract fun getContentViewLayoutId(): Int

    abstract fun initData(savedInstanceState: Bundle?)

    private fun initView() {
        ActivityCollector.addActivity(this)
        //添加相应的布局
        if (getContentViewLayoutId() != 0) {
            val view = View.inflate(this, getContentViewLayoutId(), null)
            setContentView(view)
        } else {
            throw  IllegalArgumentException("You must return layout id")
        }
    }

    fun back(v: View) {
        onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }
}