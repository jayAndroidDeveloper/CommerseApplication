package com.example.simplecommerceapplication.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Store(
    @SerializedName("stores")
    val stores: List<Stores>,
) : Serializable
