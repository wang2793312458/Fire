package com.example.fire.mine.setUp

import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

/**
 * @author by 王小智
 * Created on 2018/10/18.
 */
interface SetUpContract {
    interface View : CommonView<Present> {
        var mPresent: Present
        fun setWebUrl(url: String)
        fun setPhone(phone: String)
    }

    interface Present : BasePresent {
        fun upgrade()
    }
}