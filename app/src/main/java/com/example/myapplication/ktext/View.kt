package com.haulio.hcs.ktext

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

fun View.visible() {
	this.visibility = View.VISIBLE
}

fun View.disable(){
	this.isEnabled = false
}

fun View.enable(){
	this.isEnabled = true
}

fun View.invisible() {
	this.visibility = View.INVISIBLE
}

fun View.gone() {
	this.visibility = View.GONE
}

fun ViewGroup.inflate(@LayoutRes layoutResId: Int, attachToRoot: Boolean = false): View {
	return LayoutInflater.from(context).inflate(layoutResId, this, attachToRoot)
}

fun ViewGroup.children(): List<View> {
	return (0 until childCount).map { getChildAt(it) }
}