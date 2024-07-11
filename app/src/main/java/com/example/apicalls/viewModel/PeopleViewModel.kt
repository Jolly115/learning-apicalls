package com.example.apicalls.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apicalls.model.PeopleItems
import com.example.apicalls.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleViewModel:ViewModel() {

    private val _peopleList = MutableLiveData<PeopleItems>()
    val peoplelist: LiveData<PeopleItems> get() =_peopleList

    //function to get data
    fun peopleItems(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = ApiService.getApiService().getPeoples()
            if(response.isSuccessful){
                _peopleList.postValue(response.body())
            }
        }
    }
}