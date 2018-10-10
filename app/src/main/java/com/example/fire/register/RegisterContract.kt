package com.example.fire.register

import android.content.Context
import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

/**
 * @author by 王小智
 * Created on 2018/10/9.
 */
interface RegisterContract {
  interface View : CommonView<Present> {
    var mPresent: Present

    fun getContext(): Context
    fun getPhone(): String
    fun getCode(): String
    fun setCode(code: String)
    fun getPassWord(): String
    fun getPassWordAgain(): String
    fun jumpNext()
    fun setIsClickable(b: Boolean)
    fun setIsSelected(b: Boolean)

  }

  interface Present : BasePresent {
    fun getCode()
    fun checkCode()
    fun getRegister()
  }
}