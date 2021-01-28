package com.zkp.jetpacktest

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zkp.jetpacktest.databinding.ActivityMainBinding
import com.zkp.jetpacktest.viewmodel.MainViewModelFactory
import com.zkp.jetpacktest.viewmodel.MainViewModl

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModl: MainViewModl
    lateinit var sp : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sp= getPreferences(Context.MODE_PRIVATE)
        val countResered =  sp.getInt("count_reserved",0)
        viewModl = ViewModelProvider(this, MainViewModelFactory(countResered)).get(MainViewModl ::class.java)
        binding.button1.setOnClickListener {
            viewModl.plusOne()
        }
        binding.buttonClean.setOnClickListener {
            viewModl.clear()
        }

        /**
         *  观察者模式 通过观察数据的变化，来动态给页面赋值
         */
        viewModl.counter.observe(this, Observer {count ->
            binding.textView.text = count.toString()
        })

    }


    private fun refreshCounter(){
        binding.textView.text = viewModl.counter.toString()
    }

    override fun onPause() {
        super.onPause()
        sp.edit {
            putInt("count_reserved",viewModl.counter.value ?:0)
        }
    }
}