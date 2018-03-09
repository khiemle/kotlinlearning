package com.mingle.kotlinlearning

import android.content.Context
import com.mingle.kotlinlearning.models.UserRepository
import com.mingle.kotlinlearning.models.datasources.NetManager
import com.mingle.kotlinlearning.viewmodels.UsersViewModelFactory

object Injection {

    private fun provideNetManager(context: Context) : NetManager{
        return NetManager(context)
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