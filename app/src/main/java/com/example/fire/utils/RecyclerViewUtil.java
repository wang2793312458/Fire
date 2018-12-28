package com.example.fire.utils;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by iCong.
 * Time:2016/12/12-17:35.
 */

public class RecyclerViewUtil {
    /**
     * 判断RecyclerView是否已经滚动到底部
     */
    public static boolean isScrollBottom(RecyclerView recyclerView) {
        return recyclerView.computeVerticalScrollExtent()
                + recyclerView.computeVerticalScrollOffset()
                >= recyclerView.computeVerticalScrollRange();
    }
}
