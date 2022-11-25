package com.example.simplecommerceapplication.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplecommerceapplication.adapter.ProductAdapter
import com.example.simplecommerceapplication.adapter.StoreAdapter
import com.example.simplecommerceapplication.databinding.ActivityMainBinding
import com.example.simplecommerceapplication.util.Util

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.cart.setOnClickListener {
            val intent = Intent(this , Cart::class.java)
            startActivity(intent)
        }

        val productList = Util.getAllProducts(this , "products.json" )
        val storeList = Util.getAllStores(this , "stores.json" )


        binding.productRview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity , LinearLayoutManager.VERTICAL , false)
        }
        binding.productRview.adapter = ProductAdapter( this,productList!!)


        binding.storesRview.apply {
            layoutManager = LinearLayoutManager(this@MainActivity , LinearLayoutManager.VERTICAL , false)
        }
        binding.storesRview.adapter = StoreAdapter(this ,storeList!!)


    }

}

