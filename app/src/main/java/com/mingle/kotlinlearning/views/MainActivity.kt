package com.mingle.kotlinlearning.views

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mingle.kotlinlearning.R
import com.mingle.kotlinlearning.databinding.ActivityMainBinding
import com.mingle.kotlinlearning.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainviewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.btnUsers.setOnClickListener {
            startActivity(Intent(this, UsersActivity::class.java))
        }
    }
}
