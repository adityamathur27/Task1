package com.example.task1.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task1.R
import com.example.task1.data.data_class
import com.example.task1.data.data_classItem

class RecyclerViewAdapter(var items : ArrayList<data_classItem>) : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val currentItem = items[position]
        holder.loginName.text = currentItem.login.capitalize()
        holder.id.text = currentItem.id.toString()

        Glide.with(holder.imageView.context)
            .load(currentItem.avatar_url)
            .dontAnimate()
            .into(holder.imageView)
    }
    fun updateData(newData: ArrayList<data_classItem>){
        items.clear()
        items.addAll(newData)
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
class Holder(itemView : View) :RecyclerView.ViewHolder(itemView){
    val imageView : ImageView = itemView.findViewById(R.id.profile_image)
    val loginName : TextView = itemView.findViewById(R.id.login_name)
    val id : TextView = itemView.findViewById(R.id.idNumber)
}
