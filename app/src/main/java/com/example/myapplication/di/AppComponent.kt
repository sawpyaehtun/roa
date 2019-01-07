package com.example.myapplication.di

import com.example.myapplication.ROA
import com.example.myapplication.di.module.ActivityModule
import com.example.myapplication.di.module.AppModule
import com.example.myapplication.di.module.SharedPreferencesModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import javax.inject.Singleton


@Singleton
@Component(modules = [
	AppModule::class,
	ActivityModule::class,
	AndroidSupportInjectionModule::class,
    SharedPreferencesModule::class
])

interface AppComponent : AndroidInjector<DaggerApplication> {
	fun inject(roa: ROA)
	
	@Component.Builder
	interface Builder {
		fun build(): AppComponent
		
		@BindsInstance
		fun roaApp(application: ROA): Builder
	}
}