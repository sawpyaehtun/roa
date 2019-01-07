package com.example.myapplication.retrofit

import com.example.myapplication.entity.AuthEntity
import com.example.myapplication.entity.request.SignInBody
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("login")
    fun signIn(@Body body: SignInBody) : Observable<AuthEntity>


}
