package com.example.fire.mine.address.list.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fire.R
import com.example.fire.mine.address.entity.MineAddressData
import kotlinx.android.synthetic.main.item_address.view.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * @author by 王小智
 * Created on 2018/10/19.
 */
class MineAddressListAdapter : RecyclerView.Adapter<MineAddressListAdapter.MineAddressListViewHolder>() {
    private var list = arrayListOf<MineAddressData>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MineAddressListViewHolder {
        return MineAddressListViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_address, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MineAddressListViewHolder, p1: Int) {
        val data = list[p1]
        holder.itemView.tvName.text = data.address
        holder.itemView.tvDelete.onClick {
            listener!!.delete(p1)
        }
    }


    fun setList(list: ArrayList<MineAddressData>?) {
        list?.let {
            this.list = list
            notifyDataSetChanged()
        }
    }

    fun addList(list: ArrayList<MineAddressData>?) {
        list?.let {
            this.list.addAll(list)
            notifyDataSetChanged()
        }
    }

    inner class MineAddressListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private var listener: onKotlinItemClickListener? = null

    fun setOnItemClickListener(listener: onKotlinItemClickListener) {
        this.listener = listener
    }

    interface onKotlinItemClickListener {

        fun delete(position: Int)
    }
}