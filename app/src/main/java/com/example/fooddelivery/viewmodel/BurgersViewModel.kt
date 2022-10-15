package com.example.fooddelivery.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.Burgers
import com.example.fooddelivery.data.network.BurgersApi
import kotlinx.coroutines.launch

class BurgersViewModel : ViewModel() {

    private var _burgers = MutableLiveData<Burgers>()
    val burgers get() = _burgers


    init {
        getBurgers()
    }

    private fun getBurgers() {
        viewModelScope.launch {
            try {
                _burgers.value = BurgersApi.retrofitService.getBurgers()

            } catch (e: Exception) {
                _burgers.value = Burgers()
            }
        }
    }
}