package com.mingle.kotlinlearning.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.mingle.kotlinlearning.models.User
import com.mingle.kotlinlearning.models.UserRepository
import com.mingle.kotlinlearning.models.datasources.NetManager
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class UsersViewModel(context: Application) : AndroidViewModel(context) {

    private val userRepository = UserRepository(NetManager(context))
    var users = MutableLiveData<ArrayList<User>>()
    val isLoading = ObservableField(false)

    fun getListUsers() {
        isLoading.set(true)
        userRepository.getUsers().subscribe(object : Observer<ArrayList<User>> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onComplete() {
                isLoading.set(false)
            }

            override fun onNext(data: ArrayList<User>) {
                users.postValue(data)
            }

            override fun onError(e: Throwable) {
            }

        })
    }
}