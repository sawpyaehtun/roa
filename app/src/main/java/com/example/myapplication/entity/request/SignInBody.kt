package com.example.myapplication.entity.request

import java.io.Serializable

class SignInBody(
		val password : String,
		val device_id : String
): Serializable