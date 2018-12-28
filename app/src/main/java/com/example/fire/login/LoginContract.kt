package com.example.fire.login

import com.example.fire.common.BasePresent
import com.example.fire.common.CommonView

/**
 * @author by 王小智
 * Created on 2018/10/8.
 */
interface LoginContract {
    interface View : CommonView<Present> {
        var mPresent: Present
        fun getPhone(): String
        fun getPwd(): String
        fun jumpMainActivity()
    }

    interface Present : BasePresent {
        fun login()
    }
}