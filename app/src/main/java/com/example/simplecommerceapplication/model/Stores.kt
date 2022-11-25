package com.example.simplecommerceapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable




data class Stores(
    @SerializedName("name")
    val name : String,
    @SerializedName("address")
    val address : String,
    @SerializedName("phone")
    val phone : String,
    @SerializedName("imageUrl")
    val imageUrl : String,
) : Serializable
