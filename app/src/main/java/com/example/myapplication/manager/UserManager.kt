package com.example.myapplication.manager


/**
 * Collection of Interface related with Driver and Driver Location
 * Implementation can be see at UserManagerImpl
 */
interface UserManager {
	fun clearUserData()
	fun setIsUserSignedIn(isSignedIn: Boolean)
	fun storeOldPassword(password: String)
	fun getCurrentShiftStatus(): Boolean
	fun checkMD5match(updatePassword : String): Boolean
	fun storeCurrentShiftStatus(status: Boolean?)
	fun getOldPassword():String
	
}