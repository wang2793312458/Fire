package com.example.fire.mine.info

import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

/**
 * @author by 王小智
 * Created on 2018/10/19.
 */
interface MeInfoContract {
  interface View : CommonView<Present> {
    var mPresent: Present
    fun setName(name: String)
    fun setHeadPic(headPic: String)
  }

  interface Present : BasePresent {

  }
}