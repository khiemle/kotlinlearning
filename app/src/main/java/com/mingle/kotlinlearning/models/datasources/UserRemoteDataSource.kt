package com.mingle.kotlinlearning.models.datasources

import android.os.Handler
import com.mingle.kotlinlearning.models.User

class UserRemoteDataSource : UserDataSource() {
    override fun getUsers(onUsersReadyCallback: OnUsersReadyCallback) {
        Handler().postDelayed({
            val listUsers = ArrayList<User>()
            (1..10).mapTo(listUsers) { User(name = "User $it", age = 29, email = "user$it@gmail.com", company = "Mingle") }
            onUsersReadyCallback.onUsersReady(listUsers)
        },3000)
    }
}
