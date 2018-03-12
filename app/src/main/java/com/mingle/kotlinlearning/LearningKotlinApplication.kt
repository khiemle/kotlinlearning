package com.mingle.kotlinlearning

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class LearningKotlinApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}