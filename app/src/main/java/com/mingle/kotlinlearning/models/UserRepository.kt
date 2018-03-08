package com.mingle.kotlinlearning.models

import com.mingle.kotlinlearning.models.datasources.NetManager
import com.mingle.kotlinlearning.models.datasources.OnUsersReadyCallback
import com.mingle.kotlinlearning.models.datasources.UserLocalDataSource
import com.mingle.kotlinlearning.models.datasources.UserRemoteDataSource

class UserRepository(private val netManager: NetManager) {
    private val localDataSource = UserLocalDataSource()
    private val remoteDataSource = UserRemoteDataSource()

    fun getUsers(onUsersReadyCallback: OnUsersReadyCallback) {
        netManager.isConnectedToInternet?.let {
            if (it) {
                remoteDataSource.getUsers(object : OnUsersReadyCallback {
                    override fun onUsersReady(data: ArrayList<User>) {
                        onUsersReadyCallback.onUsersReady(data)
                    }
                })
            } else {
                localDataSource.getUsers(object : OnUsersReadyCallback {
                    override fun onUsersReady(data: ArrayList<User>) {
                        onUsersReadyCallback.onUsersReady(data)
                    }
                })
            }
        }
    }
    fun saveUsers(data : ArrayList<User>) {
        //TODO save data
    }
}

