package com.mingle.kotlinlearning

import android.annotation.SuppressLint
import android.content.Context
import com.mingle.kotlinlearning.models.UserRepository
import com.mingle.kotlinlearning.models.datasources.NetManager
import com.mingle.kotlinlearning.viewmodels.UsersViewModelFactory

object Injection {

    @SuppressLint("StaticFieldLeak")
    private var NET_MANAGER : NetManager? = null

    private fun provideNetManager(context: Context) : NetManager{
        NET_MANAGER?.let {
            return NET_MANAGER!!
        }
        NET_MANAGER = NetManager(context)
        return NET_MANAGER!!
    }

    private fun provideUserRepository(netManager: NetManager) : UserRepository{
        return UserRepository(netManager)
    }

    fun provideUsersMainViewFactory(context: Context) : UsersViewModelFactory {
        val netManager = provideNetManager(context)
        val userRepository = provideUserRepository(netManager)
        return UsersViewModelFactory(userRepository)
    }
}