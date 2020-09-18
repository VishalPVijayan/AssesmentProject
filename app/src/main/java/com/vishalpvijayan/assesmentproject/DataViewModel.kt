package com.vishalpvijayan.assesmentproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job

class DataViewModel ( private val reposiotry : DataRepository ): ViewModel() {

    private lateinit var job : Job

    // DEFINING MUTABLE LIVEDATA AS PRIVATE WHICH SHOULD NOT CHANGE
    private val all_data = MutableLiveData<List<DataResponse>>()

    // LIVE DATA ACCESSIBLE OUTSIDE
    val data : LiveData<List<DataResponse>>
    get() = all_data

     fun getData(){
        job = IO_threadHandling.ioThenMain(
            { reposiotry.getData() },
            { all_data.value = it }
        )
    }
    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}