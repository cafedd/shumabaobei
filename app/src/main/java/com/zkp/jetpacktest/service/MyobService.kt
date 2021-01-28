package com.zkp.jetpacktest.service

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * Created by zhukunpeng on 2021/1/28 12:38 AM.
 */
class MyobService :LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activityStart(){
        Log.d("MyObservice","activityStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun activityStop(){
        Log.d("MyObservice","activityStop")
    }
}