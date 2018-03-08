package com.mingle.kotlinlearning.models.datasources

import android.os.Handler
import com.mingle.kotlinlearning.models.User

class UserLocalDataSource {
    fun getUsers(onLocalUsersReadyCallback: OnLocalUsersReadyCallback) {
        Handler().postDelayed({
            val listUsers = ArrayList<User>()
            (1..10).mapTo(listUsers) { User(name = "User $it", age = 29, email = "user$it@gmail.com", company = "Mingle") }
            onLocalUsersReadyCallback.onLocalUsersReady(listUsers)
        },200)
    }
}

interface OnLocalUsersReadyCallback {
    fun onLocalUsersReady(data : ArrayList<User>)
}