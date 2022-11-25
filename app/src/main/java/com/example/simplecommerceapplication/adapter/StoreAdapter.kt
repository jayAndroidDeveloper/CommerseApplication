package com.example.simplecommerceapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplecommerceapplication.R
import com.example.simplecommerceapplication.model.Store


class StoreAdapter( private val context: Context, private val storeList : Store) : RecyclerView.Adapter<StoreAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.storetitle)
        val phone : TextView = itemView.findViewById(R.id.storephone)
        val address : TextView = itemView.findViewById(R.id.storeaddress)
        val imageview : ImageView = itemView.findViewById(R.id.storeimage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.storelist_design ,  parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.title.text = storeList.stores[position].name
       holder.phone.text = storeList.stores[position].phone
       holder.address.text = storeList.stores[position].address

        Glide.with(context).load(storeList.stores[position].imageUrl).into(holder.imageview)
    }

    override fun getItemCount(): Int {
        return storeList.stores.size
    }
}