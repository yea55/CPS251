package com.example.namesavedata.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData


class MainViewModel : ViewModel() {
    private var namesInit = ""
    private var inputName : MutableLiveData<String> = MutableLiveData()
    private var names = ""//: MutableLiveData<String> = MutableLiveData()
    private var nameList: MutableList<String> = mutableListOf()
    fun addName(value: String){
        this.namesInit = value
        names = value
        //names.value = value.toString()
        nameList.add(value + "\n")
    }
    //@JvmName("getNames1")
    fun getNamesList(): List<String> {
        return nameList
    }
    fun getNames(): String{
        return names
    }

}