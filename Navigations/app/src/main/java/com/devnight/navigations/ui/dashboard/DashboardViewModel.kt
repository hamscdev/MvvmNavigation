package com.devnight.navigations.ui.dashboard

import androidx.lifecycle.*
import com.devnight.navigations.data.model.ProductItem
import com.devnight.navigations.domain.UsesCases
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {


    val modelList = MutableLiveData(emptyList<ProductItem>())
    val usesCases = UsesCases()


    fun createList(){
        viewModelScope.launch {
            val result = usesCases.getAllProducts()
            if (!result.isNullOrEmpty()){
                modelList.value = result
            }
        }

    }


    fun searchText(search: String){

        viewModelScope.launch {
           val resultado = usesCases.getAllProducts()
            if (!resultado.isNullOrEmpty()){
                modelList.value = resultado.filter { it.name.contains(search) }
            }
        }
    }



}