package com.example.simplecommerceapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Products")
data class DataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val price: String,
    val content: String,
    val imageUrl: String
)