package com.devnight.navigations.data.repository

import com.devnight.navigations.data.model.StoreItem
import com.devnight.navigations.data.network.ApiServices

class EstablishmentsRepository {


    private val api = ApiServices()
    suspend fun getAllEstablishments(): List<StoreItem> = api.getAllEstablishments()


}