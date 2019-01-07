package com.example.myapplication.interact

import io.reactivex.Single

interface LogInInteract {
    fun login() : Single<String>
}