package com.mingle.kotlinlearning.viewmodels

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.mingle.kotlinlearning.models.User
import com.mingle.kotlinlearning.models.UserRepository
import com.mingle.kotlinlearning.models.datasources.NetManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}

class UsersViewModel(context: Application) : AndroidViewModel(context) {

    private val userRepository = UserRepository(NetManager(context))
    var users = MutableLiveData<ArrayList<User>>()
    val isLoading = ObservableField(false)
    private val compositeDisposable = CompositeDisposable()
    fun getListUsers() {
        isLoading.set(true)
        compositeDisposable += userRepository.getUsers()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<ArrayList<User>>(){
            override fun onComplete() {
                isLoading.set(false)
            }

            override fun onNext(data: ArrayList<User>) {
                users.value = data
            }

            override fun onError(e: Throwable) {
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.dispose()
        }
    }
}