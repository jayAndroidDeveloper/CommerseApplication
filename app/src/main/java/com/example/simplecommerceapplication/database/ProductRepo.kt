package com.example.simplecommerceapplication.database

import android.icu.text.CaseMap
import androidx.lifecycle.LiveData
import com.example.simplecommerceapplication.model.DataModel
import com.example.simplecommerceapplication.model.Product

class ProductRepo(private val productDao: ProductDao) {

    val readAllData: LiveData<List<DataModel>> =  productDao.readAllData()

    fun addProduct(product: DataModel){
        productDao.addProduct(product)
    }


    fun deleteProduct(title: String){
        productDao.deleteProduct(title)
    }
}