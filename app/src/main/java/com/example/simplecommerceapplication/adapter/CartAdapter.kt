package com.example.simplecommerceapplication.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.simplecommerceapplication.R
import com.example.simplecommerceapplication.database.ProductDataBase
import com.example.simplecommerceapplication.model.DataModel

class CartAdapter(private val context: Context) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {


    private var productList = emptyList<DataModel>()




    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.carttitle)
        val price : TextView = itemView.findViewById(R.id.cartprice)
        val content : TextView = itemView.findViewById(R.id.cartcontent)
        val imageview : ImageView = itemView.findViewById(R.id.cartImage)
        val delete : Button = itemView.findViewById(R.id.deleteItm)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.title.text = currentItem.title
        holder.price.text = currentItem.price
        holder.content.text = currentItem.content

        Glide.with(context).load(currentItem.imageUrl).into(holder.imageview)

        holder.delete.setOnClickListener {
            val db = ProductDataBase.getDatabase(holder.title.context)
            val productDao = db.productDao()
            productDao.deleteProduct(holder.title.text.toString())
        }

    }

    override fun getItemCount(): Int {
        return productList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setData(product: List<DataModel>) {
        this.productList = product
        notifyDataSetChanged()
    }
}