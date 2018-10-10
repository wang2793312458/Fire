package com.example.fire.message.adapter

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fire.R
import com.example.fire.common.Api
import com.example.fire.message.adapter.MessageAdapter.MessageHolder
import com.example.fire.message.entity.MessageData
import kotlinx.android.synthetic.main.fragment_mine.view.tvName
import kotlinx.android.synthetic.main.item_message.view.ivImage
import kotlinx.android.synthetic.main.item_message.view.tvTitle

class MessageAdapter : RecyclerView.Adapter<MessageHolder>() {
  private var list = arrayListOf<MessageData>()

  override fun onCreateViewHolder(
    parent: ViewGroup,
    p1: Int
  ): MessageHolder {
    return MessageHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
    )
  }

  override fun getItemCount(): Int {
    return list.size
  }

  fun setList(list: ArrayList<MessageData>) {
    this.list = list
    notifyDataSetChanged()
  }

  fun addList(list: ArrayList<MessageData>) {
    this.list.addAll(list)
    notifyDataSetChanged()
  }

  override fun onBindViewHolder(
    holder: MessageHolder,
    position: Int
  ) {
    val data = list[position]
    holder.itemView.tvTitle.text = data.title
    Glide.with(holder.itemView)
        .load(Api.API_LOAD_IMAGE + data.picture)
        .apply(RequestOptions().centerCrop())
        .into(holder.itemView.ivImage)
  }

  inner class MessageHolder(itemView: View) : ViewHolder(itemView)
}