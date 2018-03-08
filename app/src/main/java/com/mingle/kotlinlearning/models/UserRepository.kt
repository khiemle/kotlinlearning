package com.mingle.kotlinlearning.models

import com.mingle.kotlinlearning.models.datasources.OnUsersReadyCallback
import com.mingle.kotlinlearning.models.datasources.UserLocalDataSource
import com.mingle.kotlinlearning.models.datasources.UserRemoteDataSource

class UserRepository {
    val localDataSource = UserLocalDataSource()
    val remoteDataSource = UserRemoteDataSource()

    fun getUsers(onUsersReadyCallback: OnUsersReadyCallback) {
        localDataSource.getUsers(object : OnUsersReadyCallback {
            override fun onUsersReady(data: ArrayList<User>) {
                onUsersReadyCallback.onUsersReady(data)
            }
        })
    }
    fun saveUsers(data : ArrayList<User>) {
        //TODO save data
    }
}

