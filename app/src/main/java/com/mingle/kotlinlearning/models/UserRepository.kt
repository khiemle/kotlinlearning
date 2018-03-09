package com.mingle.kotlinlearning.models

import com.mingle.kotlinlearning.models.datasources.NetManager
import com.mingle.kotlinlearning.models.datasources.UserLocalDataSource
import com.mingle.kotlinlearning.models.datasources.UserRemoteDataSource
import io.reactivex.Observable

class UserRepository(private val netManager: NetManager) {
    private val localDataSource = UserLocalDataSource()
    private val remoteDataSource = UserRemoteDataSource()

    fun getUsers() : Observable<ArrayList<User>>{
        netManager.isConnectedToInternet?.let {
            if (it) {
                return remoteDataSource.getUsers()
            }
        }
        return localDataSource.getUsers()
    }

    fun saveUsers(data : ArrayList<User>) {
        //TODO save data
    }
}

