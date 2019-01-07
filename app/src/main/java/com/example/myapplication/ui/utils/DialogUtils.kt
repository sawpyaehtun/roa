package com.haulio.hcs.ui.utils

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.support.annotation.ArrayRes
import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import com.example.myapplication.R

/**
 * Created by khoi2359 on 3/1/18.
 */
object DialogUtils {
	
	private fun showSimpleListDialog(
			context: Context,
			title: String?,
			options: Array<String>,
			clickListener: DialogInterface.OnClickListener
	): AlertDialog {
		val dialog = AlertDialog.Builder(context)
				.setTitle(title)
				.setItems(options, clickListener)
				.create()
		dialog.show()
		return dialog
	}
	
	fun showSimpleListDialog(context: Context, @StringRes titleRes: Int?, @ArrayRes optionsRes: Int, clickListener: DialogInterface.OnClickListener): AlertDialog {
		return showSimpleListDialog(context, titleRes?.let { context.getString(it) }, context.resources.getStringArray(optionsRes), clickListener)
	}
	
	fun showCommonErrorDialog(context: Context) = showSimpleAlert(
			context,
			R.string.dialog_simple_error_title, R.string.dialog_simple_error_message,
			R.string.action_dismiss
	)
	
	fun showProgressDialog(context: Context): Dialog {
		val dialog = Dialog(context, R.style.TransparentDialog)
		dialog.setContentView(R.layout.dialog_simple_progress)
		dialog.setCancelable(false)
		dialog.setCanceledOnTouchOutside(false)
		dialog.show()
		return dialog
	}
	
	fun showSimpleAlert(context: Context, @StringRes titleResId: Int?, @StringRes messageResId: Int, @StringRes positiveBtnResId: Int,
	                    positiveBtnHandler: DialogInterface.OnClickListener? = null,
			@StringRes negativeBtnResId: Int? = null,
			negativeBtnHandler: DialogInterface.OnClickListener? = null
	) = showSimpleAlert(
			context,
			titleResId?.let { context.getString(it) },
			context.getString(messageResId),
			context.getString(positiveBtnResId),
			positiveBtnHandler,
			negativeBtnResId?.let { context.getString(it) },
			negativeBtnHandler
	)
	
	fun showSimpleAlert(
			context: Context,
			title: CharSequence?,
			message: CharSequence,
			positiveBtnTitle: CharSequence,
			positiveBtnHandler: DialogInterface.OnClickListener? = null,
			negativeBtnTitle: CharSequence? = null,
			negativeBtnHandler: DialogInterface.OnClickListener? = null
	): Dialog {
		val builder = AlertDialog.Builder(context)
				.setTitle(title)
				.setMessage(message)
				.setPositiveButton(positiveBtnTitle, positiveBtnHandler)
				.setNegativeButton(negativeBtnTitle, negativeBtnHandler)
				.setCancelable(false)
		
		val dialog = builder.create()
		dialog.show()
		return dialog
	}
	
	fun showErrorDialog(context: Context, message: String) = showSimpleAlert(context, context.getString(R.string.dialog_common_error_title), message, context.getString(R.string.action_dismiss))
}