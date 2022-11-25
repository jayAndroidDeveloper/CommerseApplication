package com.example.simplecommerceapplication.screen

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simplecommerceapplication.R
import com.example.simplecommerceapplication.database.ProductDataBase
import com.example.simplecommerceapplication.databinding.ActivitySuccessBinding

class SuccessActivity : AppCompatActivity() {

    lateinit var binding  : ActivitySuccessBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuccessBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button2.setOnClickListener {
            val intent  = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
            val db = ProductDataBase.getDatabase(this)
            val dao = db.productDao()
            dao.deleteAllProducts()
        }

    }
}