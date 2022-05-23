package com.example.viewmodel

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var number=0
    fun addnumber(){
        number++
    }
}