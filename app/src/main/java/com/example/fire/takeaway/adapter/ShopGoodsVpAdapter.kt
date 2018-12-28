package com.example.fire.takeaway.adapter

import androidx.fragment.app.FragmentPagerAdapter
import com.example.fire.takeaway.fragment.EvaluateFragment
import com.example.fire.takeaway.fragment.ShopGoodsFragment

/**
 * @author by 王小智
 * Created on 2018/10/25.
 */
class ShopGoodsVpAdapter(fm: androidx.fragment.app.FragmentManager?) : FragmentPagerAdapter(fm!!) {

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(p0: Int): androidx.fragment.app.Fragment {
        return if (p0 == 0) {
            ShopGoodsFragment()
        } else {
            EvaluateFragment()
        }
    }
}