package com.zkp.jetpacktest.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by zhukunpeng on 2020/12/22 6:24 PM.
 */
class MainViewModl(countResered : Int) : ViewModel() {

    var counter = MutableLiveData<Int>()

    init {
        counter.value = countResered
    }

    fun plusOne(){
        val count  = counter.value ?: 0
        counter.value = count+1
    }

    fun clear(){
        counter.value =0
    }

}