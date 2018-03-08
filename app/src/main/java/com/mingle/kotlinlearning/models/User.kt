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
}

interface OnDataReadyCallback {
    fun onDataReady(data : String)

}
