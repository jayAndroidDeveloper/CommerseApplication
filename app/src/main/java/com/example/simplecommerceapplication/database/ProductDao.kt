package com.example.simplecommerceapplication.database

import android.icu.text.CaseMap
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.simplecommerceapplication.model.DataModel

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addProduct(product: DataModel)

    @Update
    fun updateProduct(product: DataModel)



    @Query("DELETE FROM Products WHERE title = :tittle")
    fun deleteProduct(tittle: String)

    @Query("DELETE FROM Products")
    fun deleteAllProducts()

    @Query("SELECT * FROM Products ORDER BY id DESC")
    fun readAllData(): LiveData<List<DataModel>>
}