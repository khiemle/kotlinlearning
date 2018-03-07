package com.mingle.kotlinlearning.models

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Handler
import com.mingle.kotlinlearning.BR

class User(name : String, age : Int?, email : String?, company : String?) : BaseObservable() {

    constructor() : this("", null, null, null)

    @get:Bindable
    var name : String = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.name)
    }

    @get:Bindable
    var age : Int? = 0
        set(value) {
        field = value
        notifyPropertyChanged(BR.age)
    }
    @get:Bindable
    var email : String? = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.email)
    }

    @get:Bindable
    var company : String? = ""
    set(value) {
        field = value
        notifyPropertyChanged(BR.company)
    }

    init {
        this.name = name
        this.age = age
        this.company = company
        this.email = email
    }

    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        Handler().postDelayed({
            onDataReadyCallback.onDataReady("new data from refresh data")
        },2000)
    }

    companion object {
        fun getListUsers(onListUsersReadyCallback: OnListUsersReadyCallback) {
            Handler().postDelayed({
                val listUsers = ArrayList<User>()
                (1..10).mapTo(listUsers) { User(name = "User $it", age = 29, email = "user$it@gmail.com", company = "Mingle") }
                onListUsersReadyCallback.onListUsersReady(listUsers)
            },2000)
        }
    }

}

interface OnDataReadyCallback {
    fun onDataReady(data : String)

}
interface OnListUsersReadyCallback {
    fun onListUsersReady(data : ArrayList<User>)
}