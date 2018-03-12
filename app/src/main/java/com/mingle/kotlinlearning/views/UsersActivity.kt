package com.mingle.kotlinlearning.views

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.mingle.kotlinlearning.R
import com.mingle.kotlinlearning.databinding.ActivityUsersBinding
import com.mingle.kotlinlearning.models.User
import com.mingle.kotlinlearning.viewmodels.UsersViewModel
import com.mingle.kotlinlearning.viewmodels.UsersViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class UsersActivity : DaggerAppCompatActivity() {
    lateinit var binding : ActivityUsersBinding
    private val usersRvAdapter = UsersRvAdapter(arrayListOf())

    @Inject lateinit var usersViewModelFactory: UsersViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users)


        val usersViewModel = ViewModelProviders.of(this, usersViewModelFactory).get(UsersViewModel::class.java)

        binding.usersViewModel = usersViewModel
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = usersRvAdapter
        usersViewModel.users.observe(this, Observer <ArrayList<User>>{
            it?.let {
                usersRvAdapter.replaceData(it)
                usersRvAdapter.notifyDataSetChanged()
            }
        })

        binding.usersViewModel?.getListUsers()

    }
}
