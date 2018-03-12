package com.mingle.kotlinlearning

import com.mingle.kotlinlearning.models.UserRepository
import com.mingle.kotlinlearning.viewmodels.UsersViewModelFactory
import com.mingle.kotlinlearning.views.UsersActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UsersActivityModule {
    @ContributesAndroidInjector
    internal abstract fun usersActivity() : UsersActivity

    @Module
    companion object {
        @JvmStatic
        @Provides
        internal fun providesUsersViewModelFactory(userRepository: UserRepository) : UsersViewModelFactory {
            return UsersViewModelFactory(userRepository)
        }
    }
}