package com.example.fire.utils;

import net.lucode.hackware.magicindicator.MagicIndicator;

import androidx.viewpager.widget.ViewPager;

/**
 * on 2018/12/28
 * 简介：
 */
public class ViewPagerHelper {
    public ViewPagerHelper() {
    }

    public static void bind(final MagicIndicator magicIndicator, ViewPager viewPager) {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                magicIndicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            public void onPageSelected(int position) {
                magicIndicator.onPageSelected(position);
            }

            public void onPageScrollStateChanged(int state) {
                magicIndicator.onPageScrollStateChanged(state);
            }
        });
    }
}
