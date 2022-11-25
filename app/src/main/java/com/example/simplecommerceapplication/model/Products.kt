package com.example.simplecommerceapplication.model

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Products(
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    @PrimaryKey( autoGenerate = true)
    val id: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("brand")
    val brand: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("imageUrl")
    val imageUrl: String,
) : Serializable
