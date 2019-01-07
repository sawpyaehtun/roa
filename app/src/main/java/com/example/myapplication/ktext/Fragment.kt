package com.haulio.hcs.ktext

import android.os.Bundle
import android.support.v4.app.Fragment

fun Fragment.args(): Bundle {
	var args = this.arguments
	if (args == null) {
		args = Bundle()
		this.arguments = args
	}
	return args
}