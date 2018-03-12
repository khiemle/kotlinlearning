package com.mingle.kotlinlearning

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun providesContext(application: LearningKotlinApplication) : Context {
        return application.applicationContext
    }

}