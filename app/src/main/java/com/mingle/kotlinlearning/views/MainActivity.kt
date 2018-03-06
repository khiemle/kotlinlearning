package com.mingle.kotlinlearning

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.mingle.kotlinlearning.databinding.ActivityMainBinding
import com.mingle.kotlinlearning.models.User

class MainActivity : AppCompatActivity() {

    private var a : String? = null
    private var user : User? = null
    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        user = User(name = "Le Quang Khiem", age = 23, email = "khiemlq@gmail.com", company = "Mingle")
        binding?.setVariable(BR.user, user)
        binding?.executePendingBindings()

//        binding?.apply {
//            edUserName.setText("Nguyen Thi Hoang Sa")
//            edAge.setText("12")
//            edEmail.setText("lisa.nguyen19@gmail.com")
//            edCompany.setText("Mingle")
//        }
        a = null
        exampleFun()

    }

    fun exampleFun() {
        Log.d("===", a?.length.toString())
        Handler().postDelayed({
            user?.name="New Name"
            user?.company="Mingle234"
            binding?.executePendingBindings()

        }, 2000)

    }
}
