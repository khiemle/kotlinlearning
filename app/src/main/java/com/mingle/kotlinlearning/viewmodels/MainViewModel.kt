package com.mingle.kotlinlearning.viewmodels

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField
import com.mingle.kotlinlearning.models.OnDataReadyCallback
import com.mingle.kotlinlearning.models.User

class MainViewModel : ViewModel() {

    var userModel: User = User(name = "Le Quang Khiem", age = 23, email = "khiemlq@gmail.com", company = "Mingle")
    val isLoading = ObservableField(false)

    fun refresh() {
        isLoading.set(true)
        userModel.refreshData(object : OnDataReadyCallback {
            override fun onDataReady(data: String) {
                isLoading.set(false)
                userModel.apply {
                    name = "Nguyen Thi Hoang Sa"
                    age = 28
                    email = "lisa.nguyen19@gmail.com"
                    company = "VNG"
                }
            }
        })
    }
}
