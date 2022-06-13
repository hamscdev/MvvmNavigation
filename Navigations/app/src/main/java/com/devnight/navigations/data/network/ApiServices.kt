package com.devnight.navigations.data.network


import com.devnight.navigations.core.RetrofitHelper
import com.devnight.navigations.data.model.ProductItem
import com.devnight.navigations.data.model.StoreItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ApiServices {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getAllEstablishments() : List<StoreItem> {
        return withContext(Dispatchers.IO) {
            retrofit.create(ApiClient::class.java).getEstablishments().body() ?: emptyList()
        }
    }

    suspend fun getAllProducts() : List<ProductItem> {
        return withContext(Dispatchers.IO) {
            retrofit.create(ApiClient::class.java).getProducts().body() ?: emptyList()
        }
    }

}