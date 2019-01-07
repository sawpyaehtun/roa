package com.example.myapplication.presenter.impl

import com.example.myapplication.presenter.SignInPresenter
import com.example.myapplication.entity.request.SignInBody
import com.example.myapplication.views.SplashLogInView
import javax.inject.Inject

class SignInPresenterImpl @Inject constructor( val view : SplashLogInView) : SignInPresenter {
    override fun test(testString: String) {
        view.openMainScreen(testString)
    }

    override fun signIn(signInBody: SignInBody) {

    }

}