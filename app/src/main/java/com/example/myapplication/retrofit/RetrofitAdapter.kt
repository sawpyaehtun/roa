package com.example.myapplication.retrofit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitAdapter {

    fun createService( baseurl : String) : AuthService
    {
        var restAdapter = Retrofit.Builder().baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create()).build()
        var mService = restAdapter.create(AuthService::class.java)
        return mService
    }

    fun createObserableService ( baseurl : String ) : AuthService
    {
        var resAdapter = Retrofit.Builder().baseUrl(baseurl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
        var mService = resAdapter.create(AuthService::class.java)
        return mService
    }
}