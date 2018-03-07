package com.mingle.kotlinlearning.views

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mingle.kotlinlearning.R
import com.mingle.kotlinlearning.databinding.ActivityUsersBinding
import com.mingle.kotlinlearning.viewmodels.UsersViewModel

class UsersActivity : AppCompatActivity() {
    lateinit var binding : ActivityUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        binding.usersViewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
    }
}
