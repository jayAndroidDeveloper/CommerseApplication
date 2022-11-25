package com.example.simplecommerceapplication.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.simplecommerceapplication.model.DataModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<DataModel>>
    private val productRepo: ProductRepo


    init {
        val productDao = ProductDataBase.getDatabase(
            application
        ).productDao()
        productRepo = ProductRepo(productDao)
        readAllData = productRepo.readAllData
    }

    fun addProduct(product: DataModel){
        viewModelScope.launch (Dispatchers.IO){
            productRepo.addProduct(product)
        }
    }

    fun deleteProduct(title : String){
        viewModelScope.launch(Dispatchers.IO) {
            productRepo.deleteProduct(title)
        }
    }
}