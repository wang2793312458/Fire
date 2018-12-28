package com.example.fire.mine.address.list

import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

/**
 * @author by 王小智
 * Created on 2018/10/19.
 */
interface MineAddressListContract {

    interface View : CommonView<Present> {
        var mPresent: Present
    }

    interface Present : BasePresent {
        fun attachRecyclerView(recyclerView: androidx.recyclerview.widget.RecyclerView)
    }
}