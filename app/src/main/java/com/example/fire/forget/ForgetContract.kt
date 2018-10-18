package com.example.fire.forget

import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

/**
 * @author by 王小智
 * Created on 2018/10/10.
 */
interface ForgetContract {
  interface View : CommonView<Present> {
    var mPresent: Present
    fun getPhone(): String
    fun getCode(): String
    fun getPassWord(): String
    fun setCode(code: String)
    fun setIsClickable(b: Boolean)
    fun setIsSelected(b: Boolean)
    fun jumpNext()
  }

  interface Present : BasePresent {
    fun getCode()
    fun checkCode()
    fun getForeignPwd()
  }
}