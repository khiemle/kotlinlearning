package com.mingle.kotlinlearning.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.mingle.kotlinlearning.models.User
import com.mingle.kotlinlearning.models.UserRepository
import com.mingle.kotlinlearning.models.datasources.NetManager
import com.mingle.kotlinlearning.models.datasources.OnUsersReadyCallback

class UsersViewModel(context: Application) : AndroidViewModel(context) {

    private val userRepository = UserRepository(NetManager(context))
    var users = MutableLiveData<ArrayList<User>>()
    val isLoading = ObservableField(false)

    fun getListUsers() {
        isLoading.set(true)
        userRepository.getUsers(object : OnUsersReadyCallback {
            override fun onUsersReady(data: ArrayList<User>) {
                isLoading.set(false)
                users.value = data
            }
        })
    }
}