package com.example.fire.home

import android.support.v7.widget.RecyclerView
import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

/**
 * @author by 王小智
 * Created on 2018/10/19.
 */
interface HomeContract {
  interface View : CommonView<Present> {
    var mPresent: Present
  }

  interface Present : BasePresent {
    fun attachRecyclerView(recyclerView: RecyclerView)
  }
}