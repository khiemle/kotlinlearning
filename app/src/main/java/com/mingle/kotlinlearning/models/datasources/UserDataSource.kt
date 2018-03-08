package com.mingle.kotlinlearning.models.datasources

import com.mingle.kotlinlearning.models.User

abstract class UserDataSource {
    abstract fun getUsers(onUsersReadyCallback: OnUsersReadyCallback)
}

interface OnUsersReadyCallback {
    fun onUsersReady(data : ArrayList<User>)
}
