package com.example.myapplication.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
object SharedPreferencesModule {
	
	const val PREF_USER_MANAGER = "pref_user_manager"
	const val PREF_CREDENTIALS = "pref_credentials"
	
	@Provides
	@JvmStatic
	@Named(PREF_USER_MANAGER)
	fun getUserManagerPref(context: Context): SharedPreferences =
			context.getSharedPreferences(PREF_USER_MANAGER, Context.MODE_PRIVATE)
	
	@Provides
	@JvmStatic
	@Named(PREF_CREDENTIALS)
	fun getCredentialsPref(context: Context): SharedPreferences =
			context.getSharedPreferences(PREF_CREDENTIALS, Context.MODE_PRIVATE)
}