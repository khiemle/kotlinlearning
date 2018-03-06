package com.mingle.kotlinlearning.views

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.mingle.kotlinlearning.BR
import com.mingle.kotlinlearning.R
import com.mingle.kotlinlearning.databinding.ActivityMainBinding
import com.mingle.kotlinlearning.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {

    private var a : String? = null
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainviewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        a = null
        exampleFun()

    }

    fun exampleFun() {
        Log.d("===", a?.length.toString())
        Handler().postDelayed({
            binding.executePendingBindings()

        }, 2000)

    }
}
