package com.example.fire.message

import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

interface MessageContract {
    interface View : CommonView<Present> {
        var mPresent: Present
    }

    interface Present : BasePresent {
        fun refresh()
        fun attachRecyclerView(recyclerView: androidx.recyclerview.widget.RecyclerView)
    }
}