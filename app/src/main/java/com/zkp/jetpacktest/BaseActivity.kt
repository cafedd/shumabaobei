package com.zkp.jetpacktest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import com.zkp.jetpacktest.service.MyobService

/**
 * Created by zhukunpeng on 2021/1/28 12:36 AM.
 */
open class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(MyobService())
    }
}