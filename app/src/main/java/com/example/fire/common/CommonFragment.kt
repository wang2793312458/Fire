package com.example.fire.common

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class CommonFragment : Fragment() {
    private var mView: View? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        if (mView == null) {
            initView(inflater, container)
        } else {
            container!!.removeView(mView)
        }
        return mView
    }

    private fun initView(inflater: LayoutInflater?, container: ViewGroup?) {
        //添加相应的布局
        if (getContentViewLayoutId() != 0) {
            mView = inflater!!.inflate(getContentViewLayoutId(), container, false)
        } else {
            throw  IllegalArgumentException("You must return layout id")
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    /**
     * 获取当前布局id
     */
    abstract fun getContentViewLayoutId(): Int

    abstract fun initData()
}