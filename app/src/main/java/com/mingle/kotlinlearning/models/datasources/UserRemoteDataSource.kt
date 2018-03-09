package com.mingle.kotlinlearning.models.datasources

import com.mingle.kotlinlearning.models.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class UserRemoteDataSource : UserDataSource() {
    override fun getUsers(): Observable<ArrayList<User>> {
        val listUsers = ArrayList<User>()
        (1..10).mapTo(listUsers) { User(name = "User $it", age = 29, email = "user$it@gmail.com", company = "Mingle") }
        return Observable.just(listUsers).delay(3, TimeUnit.SECONDS)
    }

    fun saveUsers(listUsers: ArrayList<User>) : Completable {
        // Do something with listUsers
        return Single.just(true).delay(1, TimeUnit.SECONDS).toCompletable()
    }
}
