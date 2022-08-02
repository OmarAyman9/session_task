package com.oa.sessiontask

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.example.Store
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel:ViewModel() {
    private var _storesList = MutableLiveData<List<Store>>(mutableListOf())

    val storeList: LiveData<List<Store>>
        get() = _storesList

    fun getStoresList(){
        viewModelScope.launch (Dispatchers.IO){
            try {
                _storesList.postValue(Network.service.getStores())
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}