package com.example.myapplication.views

interface SplashLogInView : BaseView {
	/**
	 * this fun open MainActivity
	 */
	fun openMainScreen(password: String)
	
	/**
	 * his fun show invalid signin text view
	 */
	fun showSignInError()
	
}
