package com.example.myapplication.di.module

import android.content.Context
import android.content.res.Resources
import com.example.myapplication.ROA
import com.example.myapplication.manager.UserManager
import com.example.myapplication.manager.impl.UserManagerImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [
	AppModule.Declarations::class
])
object AppModule {
	
	@Provides
	@JvmStatic
	fun applicationContext(roaApp : ROA): Context = roaApp
	
	@Provides
	@JvmStatic
	fun appResources(appContext: Context): Resources = appContext.resources
	
	@Module
	interface Declarations {
		
		@Binds
		@Singleton
		fun userManager(userManager: UserManagerImpl): UserManager
		
//		@Binds
//		@Singleton
//		fun networkManager(networkLocationManager: NetworkLocationManagerImpl): NetworkLocationManager
//
//		@Binds
//		@Singleton
//		fun credentialsManager(credentialsManager: CredentialsManagerImpl): CredentialsManager
//
//		@Binds
//		@Singleton
//		fun constantDataManager(realmConstantDataManager: RealmConstantDataManager): ConstantDataManager
	}
}