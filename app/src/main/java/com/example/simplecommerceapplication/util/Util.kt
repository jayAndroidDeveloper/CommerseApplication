package com.example.simplecommerceapplication.util

import android.content.Context
import android.widget.Toast
import com.example.simplecommerceapplication.model.Product
import com.example.simplecommerceapplication.model.Store
import com.example.simplecommerceapplication.model.Stores
import com.google.gson.GsonBuilder
import java.io.InputStream

object Util {

    fun getAllProducts(context: Context, filename: String): Product? {
        val jsonString: String
        try {
            val input: InputStream = context.assets.open(filename)
            val size: Int = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            jsonString = String(buffer, Charsets.UTF_8)

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()
        return gson.fromJson(jsonString, Product::class.java)
    }

    fun getAllStores(context: Context, filename: String): Store? {
        val jsonString: String
        try {
            val input: InputStream = context.assets.open(filename)
            val size: Int = input.available()
            val buffer = ByteArray(size)
            input.read(buffer)
            input.close()
            jsonString = String(buffer, Charsets.UTF_8)

        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
        val gsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()
        return gson.fromJson(jsonString, Store::class.java)
    }

    fun Context.toast(message : String){
        Toast.makeText(this , message , Toast.LENGTH_SHORT).show()
    }
}