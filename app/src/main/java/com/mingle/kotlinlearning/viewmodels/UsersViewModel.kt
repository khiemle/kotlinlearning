package com.mingle.kotlinlearning.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.mingle.kotlinlearning.models.User
import com.mingle.kotlinlearning.models.UserRepository
import com.mingle.kotlinlearning.models.datasources.OnUsersReadyCallback

class UsersViewModel : ViewModel() {

    private val userRepository = UserRepository()
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