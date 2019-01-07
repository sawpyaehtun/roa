package com.example.myapplication.views.activities

import android.app.Dialog
import android.content.Context
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.views.BaseView
import com.haulio.hcs.ktext.toastShort
import com.haulio.hcs.ui.utils.DialogUtils
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(), BaseView {
	private var progressDialog: Dialog? = null
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		requestedOrientation = SCREEN_ORIENTATION_SENSOR_LANDSCAPE
	}

	/**
	 * 	add action to back from current activity
	 */
	protected open fun onClickBackButton() {
		close()
	}

	/**
	 * this fun is called from BaseView to show loading
	 */
	override fun showLoading() {
		hideLoading()
		progressDialog = DialogUtils.showProgressDialog(this)
	}

	/**
	 * this fun is called from BaseView to hide loading
	 */
	override fun hideLoading() {
		progressDialog?.dismiss()
		progressDialog = null
	}

	/**
	 * this fun is called from BaseView to close current view
	 */
	override fun close() {
		finish()
	}

	/**
	 * this fun is called from BaseView to show toast message
	 */
	override fun showToast(message: String) {
		message.toastShort(this)
	}

	/**
	 * this fun is called from BaseView to show error dialog
	 */
	override fun showErrorDialog(error: Throwable) {
		DialogUtils.showErrorDialog(this, error.localizedMessage)
	}

	/**
	 * this fun is called from BaseView to show message dialog
	 */
	override fun showMessageDialog(message: String, title: String) {
		DialogUtils.showSimpleAlert(this, title, message, getString(R.string.action_dismiss))
	}

	/**
	 * this fun is called from BaseView to show common error dialog
	 */
	override fun showCommonErrorDialog() {
		DialogUtils.showCommonErrorDialog(this)
	}
	
}