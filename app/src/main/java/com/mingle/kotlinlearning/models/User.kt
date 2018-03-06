package com.mingle.kotlinlearning.models

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.mingle.kotlinlearning.BR

class User(name : String, age : Int?, email : String?, company : String?) : BaseObservable() {

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

}