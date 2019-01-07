package com.example.myapplication.di.module

import com.example.myapplication.di.module.AuthenticationModule
import com.example.myapplication.views.activities.SplashLoginActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {
	
//	@ContributesAndroidInjector(modules = [SplashModule::class, AuthenticationModule::class])
//	fun splashActivity(): SplashActivity
	
	@ContributesAndroidInjector(modules = [AuthenticationModule::class])
	fun bindsSignInActivity(): SplashLoginActivity
	
//	@ContributesAndroidInjector(modules = [AuthenticationModule::class])
//	fun registrationActivity(): RegistrationActivity
//
//	@ContributesAndroidInjector(modules = [AuthenticationModule::class])
//	fun updatePhoneNumberActivity(): UpdatePhoneNumberActivity
//
//	@ContributesAndroidInjector(modules = [AuthenticationModule::class])
//	fun updatePasswordActivity(): UpdatePasswordActivity
//
//	@ContributesAndroidInjector(modules = [LocationManagerModule::class])
//	fun mainActivity(): MainActivity
//
//	@ContributesAndroidInjector(modules = [TripFormModule::class])
//	fun tripFormActivity(): TripFormActivity
//
//	@ContributesAndroidInjector(modules = [TripFormModule::class])
//	fun addTripFormItemActivity(): AddTripFormItemActivity
//
//	@ContributesAndroidInjector(modules = [TripFormModule::class])
//	fun addTripFormPricingItemActivity(): AddTripFormPricingItemActivity
//
//	@ContributesAndroidInjector(modules = [JobModule::class, DriverModule::class])
//	fun jobDetailsActivity(): JobDetailsActivity
//
//	@ContributesAndroidInjector(modules = [JobModule::class])
//	fun addChargeActivity(): AddChargeActivity
//
//	@ContributesAndroidInjector(modules = [SupportModule::class])
//	fun feedbackActivity(): FeedbackActivity
//
//	@ContributesAndroidInjector(modules = [AuthenticationModule::class])
//	fun forgotPasswordActivity(): ForgotPasswordActivity
//
//	@ContributesAndroidInjector
//	fun webViewActivity(): WebViewActivity
//
//	@ContributesAndroidInjector(modules = [HistoryMonthlyModule::class])
//	fun HistoryMonthlyActivity(): HistoryMonthlyActivity
//
//	@ContributesAndroidInjector(modules = [SurveyModule::class])
//	fun surveyActivity(): SurveyActivity
//
}