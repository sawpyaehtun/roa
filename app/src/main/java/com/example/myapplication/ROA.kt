package com.example.myapplication

import com.example.myapplication.di.AppComponent
import com.example.myapplication.di.DaggerAppComponent
import dagger.android.DaggerApplication
import dagger.android.HasActivityInjector

class ROA : DaggerApplication(), HasActivityInjector {

    override fun applicationInjector(): AppComponent = DaggerAppComponent.builder().roaApp(this).build()

    override fun onCreate() {
        super.onCreate()

        applicationInjector().inject(this)
    }

}