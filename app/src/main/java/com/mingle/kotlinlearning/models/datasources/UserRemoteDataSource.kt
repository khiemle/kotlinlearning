package com.mingle.kotlinlearning.models.datasources

import com.mingle.kotlinlearning.models.User
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class UserRemoteDataSource : UserDataSource() {
    override fun getUsers(): Observable<ArrayList<User>> {
        val listUsers = ArrayList<User>()
        (1..10).mapTo(listUsers) { User(name = "User $it", age = 29, email = "user$it@gmail.com", company = "Mingle") }
        return Observable.just(listUsers).delay(3, TimeUnit.SECONDS)
    }
}
