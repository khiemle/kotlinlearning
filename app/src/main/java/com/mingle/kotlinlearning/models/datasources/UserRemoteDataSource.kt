package com.mingle.kotlinlearning.models.datasources

import android.os.Handler
import com.mingle.kotlinlearning.models.User

class UserRemoteDataSource {
    fun getUsers(onRemoteUsersReadyCallback: OnRemoteUsersReadyCallback) {
        Handler().postDelayed({
            val listUsers = ArrayList<User>()
            (1..10).mapTo(listUsers) { User(name = "User $it", age = 29, email = "user$it@gmail.com", company = "Mingle") }
            onRemoteUsersReadyCallback.onRemoteUsersReady(listUsers)
        },3000)
    }
}

interface OnRemoteUsersReadyCallback {
    fun onRemoteUsersReady(data : ArrayList<User>)
}