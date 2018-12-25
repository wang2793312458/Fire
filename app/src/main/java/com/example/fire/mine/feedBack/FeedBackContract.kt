package com.example.fire.mine.feedBack

import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

/**
 * @author by 王小智
 * Created on 2018/10/18.
 */
interface FeedBackContract {
    interface View : CommonView<Present> {
        var mPresent: Present
        fun getContent(): String
    }

    interface Present : BasePresent {
        fun feedback()
    }
}