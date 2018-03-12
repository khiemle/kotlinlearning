package com.mingle.kotlinlearning

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class, UsersActivityModule::class])
interface AppComponent : AndroidInjector<LearningKotlinApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<LearningKotlinApplication>()
}