package com.example.fire.common

import android.content.Context

/**
 * @author by 王小智
 * Created on 2018/10/8.
 */
interface CommonView<T> :BaseView {
  abstract fun getContext(): Context
}