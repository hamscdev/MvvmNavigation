package com.devnight.navigations.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devnight.navigations.data.model.StoreItem
import com.devnight.navigations.domain.UsesCases
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {




    val apiModel = MutableLiveData<List<StoreItem>>()
    val usesCases = UsesCases()

    fun onCreate(){
        viewModelScope.launch {
            val resultado = usesCases.getAllEstablishments()
            if (!resultado.isNullOrEmpty()) {
                apiModel.value = resultado
            }
        }
    }




}