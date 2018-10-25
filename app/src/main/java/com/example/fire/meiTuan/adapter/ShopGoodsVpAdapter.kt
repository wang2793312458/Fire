package com.example.fire.meiTuan.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.fire.meiTuan.fragment.EvaluateFragment
import com.example.fire.meiTuan.fragment.ShopGoodsFragment

/**
 * @author by 王小智
 * Created on 2018/10/25.
 */
class ShopGoodsVpAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {


    override fun getCount(): Int {
        return 2
    }

    override fun getItem(p0: Int): Fragment {
//        return if (p0 == 0) {
//            ShopGoodsFragment.getInstance("")
//        } else {
//            EvaluateFragment.getInstance("")
//        }
//        return ShopGoodsFragment
    }
}