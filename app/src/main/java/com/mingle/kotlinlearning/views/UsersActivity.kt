package com.mingle.kotlinlearning.views

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mingle.kotlinlearning.R
import com.mingle.kotlinlearning.databinding.ActivityUsersBinding
import com.mingle.kotlinlearning.viewmodels.UsersViewModel

class UsersActivity : AppCompatActivity() {
    lateinit var binding : ActivityUsersBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)
        val usersViewModel = ViewModelProviders.of(this).get(UsersViewModel::class.java)
        binding.usersViewModel = usersViewModel
        binding.usersViewModel?.getListUsers()
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = UsersRvAdapter(usersViewModel.users)

    }
}
