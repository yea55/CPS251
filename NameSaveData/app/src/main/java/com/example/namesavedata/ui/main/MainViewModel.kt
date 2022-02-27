package com.example.namesavedata.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData

class MainViewModel : ViewModel() {
    private var namesInit = ""
    //private var
    private var names: MutableLiveData<String> = MutableLiveData()
    fun addName(value:String){
        this.namesInit += value
        names.setValue(value.toString())
    }
    fun getNames(): MutableLiveData<String> {
        return names
    }

}