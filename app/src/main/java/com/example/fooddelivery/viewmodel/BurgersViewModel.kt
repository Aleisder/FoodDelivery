package com.example.fooddelivery.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddelivery.data.Burger
import com.example.fooddelivery.data.network.Retrofit
import kotlinx.coroutines.launch

private const val TAG = "BurgersViewModel"
enum class BurgersApiState {LOADING, ERROR, DONE}

class BurgersViewModel : ViewModel() {

    private var _burgers = MutableLiveData<List<Burger>>()
    val burgers get() = _burgers

    private var _status = MutableLiveData<BurgersApiState>()
    val state get() = _status

    init {
        getBurgers()
    }

    private fun getBurgers() {
        viewModelScope.launch {
            _status.value = BurgersApiState.LOADING
            try {
                _burgers.value = Retrofit.BurgersApi.getBurgers().body()
                _status.value = BurgersApiState.DONE
            } catch(e: Exception) {
                Log.e(TAG, e.message!!)
                _status.value = BurgersApiState.ERROR
            }
        }
    }
}