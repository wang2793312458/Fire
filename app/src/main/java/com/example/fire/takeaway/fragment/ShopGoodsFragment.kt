package com.example.fire.takeaway.fragment

import com.example.fire.R
import com.example.fire.common.CommonFragment

/**
 * @author by 王小智
 * Created on 2018/10/25.
 */
class ShopGoodsFragment : CommonFragment() {
    override fun getContentViewLayoutId(): Int {
        return R.layout.fragment_message
    }

    override fun initData() {
    }

    fun getInstance(companyId: String): androidx.fragment.app.Fragment {
        return ShopGoodsFragment()
    }
}