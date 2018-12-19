package com.example.fire.home.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fire.R
import com.example.fire.home.entity.HomeShopData
import kotlinx.android.synthetic.main.item_home_shop.view.*

/**
 * on 2018/12/19
 * 简介：
 */
class HomeShopAdapter : RecyclerView.Adapter<HomeShopAdapter.HomeShopViewHold>() {
    var mList = arrayListOf<HomeShopData>()

    fun setList(list: ArrayList<HomeShopData>?) {
        list?.let {
            this.mList = list
            notifyDataSetChanged()
        }
    }

    fun addList(list: ArrayList<HomeShopData>?) {
        list?.let {
            this.mList.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeShopViewHold {
        return HomeShopViewHold(LayoutInflater.from(p0.context).inflate(R.layout.item_home_shop, p0, false))
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: HomeShopViewHold, p1: Int) {
        val data = mList[p1]
        holder.itemView.tv_shop_name.text = "测试"
        holder.itemView.tv_shop_km.text = "" + data.id

    }

    inner class HomeShopViewHold(ItemView: View) : ViewHolder(ItemView)
}