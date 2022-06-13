package com.devnight.navigations.data.repository

import com.devnight.navigations.data.network.ApiServices

class ProductsRepository {

    private val api = ApiServices()
    suspend fun getProducts() = api.getAllProducts()

}