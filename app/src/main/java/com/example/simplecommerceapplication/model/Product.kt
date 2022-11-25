package com.example.simplecommerceapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Product(
    @SerializedName("products")
    val contacts: List<Products>,
) : Serializable
