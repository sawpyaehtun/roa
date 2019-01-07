package com.example.myapplication.presenter

import com.example.myapplication.entity.request.SignInBody

interface SignInPresenter {
    fun signIn( signInBody: SignInBody)
    fun test(testString : String)
}