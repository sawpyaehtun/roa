package com.haulio.hcs.ktext

import android.content.Context
import android.widget.Toast
import java.math.BigInteger
import java.security.MessageDigest

//to show toast message
fun String.toastShort(context: Context) {
	Toast.makeText(context, this, Toast.LENGTH_SHORT).show()
}

fun String.md5(): String {
	val md = MessageDigest.getInstance("MD5")
	return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}
