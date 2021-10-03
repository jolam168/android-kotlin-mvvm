package com.example.tutorial

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter : RecyclerView.Adapter<MainViewHolder>() {
    private var userList = mutableListOf<User>()

    fun setList(itemList: List<User>) {
        userList.addAll(itemList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)

        return MainViewHolder(mView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.let {
            it.itemTextView.text = userList[position].login
            it.itemImageView.setImageResource(R.mipmap.ic_launcher)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val itemTextView: TextView = itemView.findViewById(R.id.itemTextView)
    val itemImageView: ImageView = itemView.findViewById(R.id.itemImageView)

    init {

    }
}


