package com.mingle.kotlinlearning.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.mingle.kotlinlearning.models.User
import com.mingle.kotlinlearning.models.UserRepository
import com.mingle.kotlinlearning.models.datasources.NetManager
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

class UsersViewModel(context: Application) : AndroidViewModel(context) {

    private val userRepository = UserRepository(NetManager(context))
    var users = MutableLiveData<ArrayList<User>>()
    val isLoading = ObservableField(false)
    private val compositeDisposable = CompositeDisposable()
    fun getListUsers() {
        isLoading.set(true)
        val disposable = userRepository.getUsers().subscribeWith(object : DisposableObserver<ArrayList<User>>(){
            override fun onComplete() {
                isLoading.set(false)
            }

            override fun onNext(data: ArrayList<User>) {
                users.postValue(data)
            }

            override fun onError(e: Throwable) {
            }
        })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}