package com.example.viewmodel.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewmodel.data.Countries
import com.example.viewmodel.retrofit.RetroInstance
import com.example.viewmodel.retrofit.RetroServiceInterface
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CountryViewModel : ViewModel() {

    var livedataUserlist: MutableLiveData<List<Countries>?>

    init {
        livedataUserlist = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Countries>?> {
        return livedataUserlist
    }

    fun makeAPICall() {
        val retroInstance: Retrofit = RetroInstance.getRetroInstance()
        val retroService = retroInstance.create(RetroServiceInterface::class.java)
        val call=retroService.getListOfData()
        println("Local "+retroService.getListOfData().request().url().toString())
        /**
         * shortcut for this callBack Mehtod to get
         * ctrl+shit+space
         * watch the video 7:42 to get Manual Adding of this Code.
         *
         */
        call.enqueue(object : Callback<List<Countries>?> {
            override fun onResponse(call: Call<List<Countries>?>, response: Response<List<Countries>?>) {
            livedataUserlist.postValue(response.body())
            }
            override fun onFailure(call: Call<List<Countries>?>, t: Throwable) {
                livedataUserlist.postValue(null)
            }
        })

    }
}