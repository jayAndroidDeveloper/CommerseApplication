package com.example.simplecommerceapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplecommerceapplication.R
import com.example.simplecommerceapplication.model.Product
import com.example.simplecommerceapplication.screen.DetailsScreen

class ProductAdapter( private val context: Context,private val productList : Product) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(itemview : View ) : RecyclerView.ViewHolder(itemview){
        val title : TextView = itemview.findViewById(R.id.textViewtitle)
        val price : TextView = itemview.findViewById(R.id.textViewprice)
        val content : TextView = itemview.findViewById(R.id.textViewcontent)
        val imageview : ImageView = itemview.findViewById(R.id.imageView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_design , parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.title.text = productList.contacts[position].name
       holder.price.text = productList.contacts[position].price
       holder.content.text = productList.contacts[position].description

        Glide.with(context).load(productList.contacts[position].imageUrl).into(holder.imageview)

        holder.itemView.setOnClickListener {
            val intent  = Intent(context , DetailsScreen::class.java)
            intent.putExtra("ProductName" , holder.title.text)
            intent.putExtra("ProductPrice" , holder.price.text)
            intent.putExtra("ProductContent" , holder.content.text)
            intent.putExtra("ProductImage" , productList.contacts[position].imageUrl)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return  productList.contacts.size
    }
}