package com.example.simplecommerceapplication.screen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simplecommerceapplication.adapter.CartAdapter
import com.example.simplecommerceapplication.database.ProductViewModel
import com.example.simplecommerceapplication.databinding.ActivityCartBinding

class Cart : AppCompatActivity() {

    lateinit var binding: ActivityCartBinding
    lateinit var productViewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)
        val adapter1 = CartAdapter(this)

        binding.cartRview.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.cartRview.adapter = adapter1
        productViewModel.readAllData.observe(this){
            adapter1.setData(it)
        }

        binding.button.setOnClickListener {
            val intent = Intent(this,SuccessActivity::class.java)
            startActivity(intent)
        }



    }
}