package com.devnight.navigations.data.network

import com.devnight.navigations.data.model.ProductItem
import com.devnight.navigations.data.model.StoreItem
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {

    @GET("establishments")
    suspend fun getEstablishments(): Response<List<StoreItem>>

    @GET("products")
    suspend fun getProducts(): Response<List<ProductItem>>

}