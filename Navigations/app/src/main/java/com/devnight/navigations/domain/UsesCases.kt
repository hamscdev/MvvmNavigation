package com.devnight.navigations.domain

import com.devnight.navigations.data.model.ProductItem
import com.devnight.navigations.data.model.StoreItem
import com.devnight.navigations.data.repository.EstablishmentsRepository
import com.devnight.navigations.data.repository.ProductsRepository

class UsesCases {

    private val respositoryHome = EstablishmentsRepository()
    private val respositoryProduct = ProductsRepository()

    suspend fun getAllEstablishments(): List<StoreItem> = respositoryHome.getAllEstablishments()
    suspend fun getAllProducts(): List<ProductItem> = respositoryProduct.getProducts()

}