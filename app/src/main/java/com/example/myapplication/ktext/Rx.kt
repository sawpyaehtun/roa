package com.haulio.hcs.ktext

import com.example.myapplication.views.BaseView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.ioTask(): Single<T> {
	return this.subscribeOn(Schedulers.io())
			.observeOn(Schedulers.io())
}

fun <T> Single<T>.ioTaskObserveMainThread(): Single<T> {
	return this.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
}


fun <T> Single<T>.controlBaseView(view: BaseView): Single<T> {
	return this.doOnSubscribe { view.showLoading() }
			.doOnSuccess { view.hideLoading() }
			.doOnError {
				view.hideLoading()
				if (it.message != null) {
					if(!it.localizedMessage.contains("User account already exists"))
					view.showErrorDialog(it)
				} else {
					view.showCommonErrorDialog()
				}
			}
	
	
}

fun <T> Single<T>.controlLoadingView(view: BaseView): Single<T> {
	return this.doOnSubscribe { view.showLoading() }
			.doOnSuccess { view.hideLoading() }
			.doOnError { view.hideLoading() }
}