package com.example.simplecommerceapplication.screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.simplecommerceapplication.database.ProductViewModel
import com.example.simplecommerceapplication.databinding.ActivityDetailsScreenBinding
import com.example.simplecommerceapplication.model.DataModel
import com.example.simplecommerceapplication.util.Util.toast

class DetailsScreen : AppCompatActivity() {

    lateinit var binding: ActivityDetailsScreenBinding
    lateinit var productViewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.displaytitle.text = intent.getStringExtra("ProductName")
        binding.displayprice.text = intent.getStringExtra("ProductPrice")
        binding.displaycontent.text = intent.getStringExtra("ProductContent")

        Glide.with(this).load(intent.getStringExtra("ProductImage")).into(binding.displayimage)
        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        binding.addToCart.setOnClickListener {
            val product = DataModel(
                0,
                binding.displaytitle.text.toString(),
                binding.displayprice.text.toString(),
                binding.displaycontent.text.toString(),
                intent.getStringExtra("ProductImage")!!
            )
            productViewModel.addProduct(product)
            val intent  = Intent(this , Cart::class.java)
            startActivity(intent)
            finish()
            toast("Item Added To Cart")
        }


    }
}