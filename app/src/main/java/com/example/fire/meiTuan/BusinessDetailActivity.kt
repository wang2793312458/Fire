package com.example.fire.meiTuan

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import com.example.fire.R
import com.example.fire.common.CommonActivity
import com.example.fire.meiTuan.adapter.ShopGoodsVpAdapter
import kotlinx.android.synthetic.main.activity_business_detail.*
import kotlinx.android.synthetic.main.include_shop_goods_bottom.*
import kotlinx.android.synthetic.main.include_shop_goods_buy_car.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView
import org.jetbrains.anko.act

class BusinessDetailActivity : CommonActivity() {
    private val names = arrayOf("商品", "评价")

    override fun getContentViewLayoutId(): Int {
        return R.layout.activity_business_detail
    }

    override fun initData(savedInstanceState: Bundle?) {
        /**
         * viewPage初始化
         */
        initMagicIndicator()
    }

    private fun initMagicIndicator() {
        vp_shop_goods.adapter = ShopGoodsVpAdapter(supportFragmentManager)
        val commonNavigator = CommonNavigator(this)
        commonNavigator.isAdjustMode = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getTitleView(p0: Context?, p1: Int): IPagerTitleView {
                val simplePagerTitleView = SimplePagerTitleView(p0)
                simplePagerTitleView.text = names[p1]
                simplePagerTitleView.textSize = 13f
                simplePagerTitleView.normalColor = Color.parseColor("#3c3c3c")
                simplePagerTitleView.selectedColor = Color.parseColor("#FD9F36")
                simplePagerTitleView.setOnClickListener { vp_shop_goods.currentItem = p1 }
                return simplePagerTitleView
            }

            override fun getCount(): Int {
                return names.size
            }

            override fun getIndicator(p0: Context): IPagerIndicator {
                val linePagerIndicator = LinePagerIndicator(p0)
                linePagerIndicator.mode = LinePagerIndicator.MODE_EXACTLY
                linePagerIndicator.lineWidth = dip2px(p0, 20.0).toFloat()
                linePagerIndicator.lineHeight = dip2px(p0, 2.0).toFloat()
                linePagerIndicator.setColors(Color.parseColor("#FD9F36"))
                return linePagerIndicator
            }

            override fun getTitleWeight(context: Context?, index: Int): Float {
                return 1.0f
            }
        }
        mi_shop_goods.navigator = commonNavigator
        ViewPagerHelper.bind(mi_shop_goods, vp_shop_goods)
        vp_shop_goods.addOnPageChangeListener(object : androidx.viewpager.widget.ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {
            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(p0: Int) {
                if (p0 == 0) {
                    fl_shop_goods_bottom.visibility = View.VISIBLE

                    val lp = RelativeLayout.LayoutParams(
                            cl_shop_goods.layoutParams)
                    lp.setMargins(0, 0, 0, UIUtil.dip2px(act, 50.0))
                    cl_shop_goods.layoutParams = lp
                } else {
                    fl_shop_goods_bottom.visibility = View.GONE
                    rl_shop_goods_buy_car.visibility = View.GONE
                    val lp = RelativeLayout.LayoutParams(
                            cl_shop_goods.layoutParams)
                    lp.setMargins(0, 0, 0, 0)
                    cl_shop_goods.layoutParams = lp
                }
            }
        })
    }

    fun dip2px(context: Context, dpValue: Double): Int {
        val density = context.resources.displayMetrics.density
        return (dpValue * density.toDouble() + 0.5).toInt()
    }
}
