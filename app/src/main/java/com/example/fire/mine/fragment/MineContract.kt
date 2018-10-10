package com.example.fire.mine.fragment

import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

/**
 * @author by 王小智
 * Created on 2018/10/9.
 */
interface MineContract {
  interface View : CommonView<Present> {
    var mPresent: Present
    fun setName(name: String)
    fun setHeadPic(headPic: String)
    fun setSex(id: Int)
  }

  interface Present : BasePresent {

  }
}