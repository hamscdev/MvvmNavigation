package com.devnight.navigations.data.model
import com.google.gson.annotations.SerializedName


data class ProductItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
)