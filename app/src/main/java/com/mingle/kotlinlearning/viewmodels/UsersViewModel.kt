package com.mingle.kotlinlearning.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.mingle.kotlinlearning.models.OnListUsersReadyCallback
import com.mingle.kotlinlearning.models.User

class UsersViewModel : ViewModel() {

    var users = MutableLiveData<ArrayList<User>>()
    val isLoading = ObservableField(false)

    fun getListUsers() {
        isLoading.set(true)
        User.getListUsers(object : OnListUsersReadyCallback {
            override fun onListUsersReady(data: ArrayList<User>) {
                isLoading.set(false)
                users.value = data
            }
        })
    }
}