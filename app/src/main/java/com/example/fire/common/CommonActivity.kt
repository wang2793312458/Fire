package com.example.fire.common

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.example.fire.widget.MultipleStateView

@SuppressLint("Registered")
abstract class CommonActivity : FragmentActivity() {

    private lateinit var mMultipleStateView: MultipleStateView

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
            mMultipleStateView = MultipleStateView(this)
            val view = View.inflate(this, getContentViewLayoutId(), mMultipleStateView)
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

    fun showLoading() {
        mMultipleStateView.showLoading()
    }

    fun showNetError(onClickListener: View.OnClickListener) {
        mMultipleStateView.showNetError(onClickListener)
    }

    fun showEmpty(onClickListener: View.OnClickListener) {
        mMultipleStateView.showEmpty(onClickListener)
    }

    fun showContent() {
        mMultipleStateView.showContent()
    }
}