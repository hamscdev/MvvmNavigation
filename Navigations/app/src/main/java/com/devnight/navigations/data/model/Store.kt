package com.devnight.navigations.data.model

import com.google.gson.annotations.SerializedName


data class StoreItem(
    @SerializedName("address")
    val address: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
)