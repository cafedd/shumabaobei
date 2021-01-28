package com.zkp.jetpacktest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by zhukunpeng on 2021/1/28 12:09 AM.
 */
class MainViewModelFactory(private  val countResered : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModl(countResered) as T
    }
}