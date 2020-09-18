package com.vishalpvijayan.assesmentproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel ( private val reposiotry : DataRepository ): ViewModel() {

    // DEFINING MUTABLE LIVEDATA AS PRIVATE WHICH SHOULD NOT CHANGE
    private val all_data = MutableLiveData<List<DataResponse>>()

    // LIVE DATA ACCESSIBLE OUTSIDE
    val data : LiveData<List<DataResponse>>
    get() = all_data

    suspend fun getData(){
        val data = reposiotry.getData()
        all_data.value = data
    }
}