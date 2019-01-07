package com.example.myapplication.views

import android.util.Log

/**
 * Created by khoi2359 on 2/28/18.
 */
interface BaseView {
	/**
	 * to show loading progress
	 */
	fun showLoading() {}
	
	/**
	 *  to hide loading progress
	 */
	
	fun hideLoading() {}
	
	/**
	 * to show toast message
	 */
	
	fun showToast(message: String) {
		Log.d("BaseView", message)
	}
	
	/**
	 * to exit form current activity
	 */
	
	fun close() {}
	
	/**
	 *  to show error dialog
	 */
	
	fun showErrorDialog(error: Throwable) {
		Log.e("BaseView", error.localizedMessage)
	}
	
	/**
	 * to show message dialog
	 */
	
	
	fun showMessageDialog(
			message: String,
			title: String = ""
	) {
		Log.d("BaseView", message)
	}
	
	
	/**
	 * to show error dialog
	 */
	
	fun showCommonErrorDialog() {
		Log.e("BaseView", "Show common error dialog")
	}
}