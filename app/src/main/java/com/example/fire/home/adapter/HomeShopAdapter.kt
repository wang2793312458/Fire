package com.example.fire.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
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
        holder.itemView.tv_shop_name.text = "亮哥麻辣烫"
        holder.itemView.tv_shop_km.text = "" + data.id
        holder.itemView.tv_shop_min.text = "10分钟"
        holder.itemView.tv_shop_goods_num.text = "10件商品"
        holder.itemView.tv_shop_goods_sale.text = "月售20份"
        holder.itemView.tv_shop_send_price.text = "配送¥10"
        holder.itemView.tv_shop_send_goods_price.text = "起送¥10"


    }

    inner class HomeShopViewHold(ItemView: View) : ViewHolder(ItemView)
}