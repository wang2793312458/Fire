package com.example.fire.home.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fire.R
import com.example.fire.common.Api
import com.example.fire.home.adapter.HomeKeyAdapter.HomeKeyViewHold
import com.example.fire.home.entity.HomeKeyData
import com.example.fire.message.entity.MessageData
import kotlinx.android.synthetic.main.activity_forget.view.*
import kotlinx.android.synthetic.main.item_message.view.*

/**
 * @author by 王小智
 * Created on 2018/10/19.
 */
class HomeKeyAdapter : RecyclerView.Adapter<HomeKeyViewHold>() {
    private var list = arrayListOf<HomeKeyData>()

    fun setList(list: ArrayList<HomeKeyData>?) {
        list?.let {
            this.list = list
            notifyDataSetChanged()
        }
    }

    fun addList(list: ArrayList<HomeKeyData>?) {
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeKeyViewHold {
        return HomeKeyViewHold(LayoutInflater.from(p0.context).inflate(R.layout.item_message, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HomeKeyViewHold, p1: Int) {
        val data = list[p1]
        holder.itemView.tvTitle.text = data.typeName
        Glide.with(holder.itemView)
                .load(Api.API_LOAD_IMAGE + data.typePic)
                .apply(RequestOptions().centerCrop())
                .into(holder.itemView.ivImage)
    }

    inner class HomeKeyViewHold(ItemView: View) : ViewHolder(ItemView)
}