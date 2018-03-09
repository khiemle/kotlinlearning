package com.mingle.kotlinlearning.models.datasources

import com.mingle.kotlinlearning.models.User
import io.reactivex.Observable

abstract class UserDataSource {
    abstract fun getUsers() : Observable<ArrayList<User>>
}
