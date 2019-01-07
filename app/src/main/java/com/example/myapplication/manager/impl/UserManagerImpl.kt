package com.example.myapplication.manager.impl

import android.content.SharedPreferences
import com.example.myapplication.di.module.SharedPreferencesModule
import com.google.gson.Gson
import com.haulio.hcs.ktext.md5
import com.example.myapplication.manager.UserManager
import javax.inject.Inject
import javax.inject.Named

class UserManagerImpl @Inject constructor(
    @Named(SharedPreferencesModule.PREF_USER_MANAGER) val userManagerPrefs: SharedPreferences,
    val gson: Gson) : UserManager {
	override fun getOldPassword(): String {
		return userManagerPrefs.getString(KEY_MD5, null)
	}
	
	override fun checkMD5match(updatePassowd: String): Boolean {
		val oldPassword = userManagerPrefs.getString(KEY_MD5, null)
		return oldPassword.replace("\"", "") == updatePassowd.md5()
	}
	
	override fun storeOldPassword(password: String) {
		userManagerPrefs.edit().putString(KEY_MD5, password).apply()
	}
	
	override fun getCurrentShiftStatus(): Boolean {
		return userManagerPrefs.getBoolean(KEY_CURRENT_SHIFT, false)
	}
	
	companion object {
		const val KEY_DRIVER_PROFILE = "KEY_DRIVER_PROFILE"
		const val KEY_COMPANY_PAIRING = "KEY_COMPANY_PAIRING"
		const val KEY_USER_SIGNED_IN = "KEY_USER_SIGNED_IN"
		const val KEY_DESTINATION_LAT_LONG = "KEY_DESTINATION_LAT_LONG"
		const val KEY_DESTINATION_LAT_LONG_TWO = "KEY_DESTINATION_LAT_LONG"
		const val KEY_TTA_PSA_MESSAGE_STATUS = "KEY_TTA_PAS_MESSAGE_STATUS"
		const val KEY_CURRENT_SHIFT = "KEY_CHECK_SHIFT_ONOFF"
		const val KEY_MD5 = "KEY_MD5"
		
	}
	
	/**
	 * This fun is used for get company pair  info
	 */
//	override fun getCompanyPairing(): CompanyPairingEntity? {
//		val jsonValue = userManagerPrefs.getString(KEY_COMPANY_PAIRING, null)
//		return jsonValue?.let {
//			gson.fromJson(it, CompanyPairingEntity::class.java)
//		}
//	}
	
	/**
	 * This fun is used for store company paring on shared preference
	 * If they reject or un pair ,store null
	 * If they accept or paired , store company pair info
	 */
	
//	override fun storeCompanyPairing(companyPairing: CompanyPairingEntity?) {
//		val jsonValue = companyPairing?.let {
//			gson.toJson(companyPairing)
//		}
//		userManagerPrefs.edit().putString(KEY_COMPANY_PAIRING, jsonValue).apply()
//	}
	
	/**
	 * This is used for get driver profile from user shared preference when sign in success
	 */
//	override fun getDriverProfile(): DriverProfileEntity {
//		val jsonValue = userManagerPrefs.getString(KEY_DRIVER_PROFILE, null)
//		return gson.fromJson(jsonValue, DriverProfileEntity::class.java)
//	}
	
	/**
	 * This is used  for store driver profile on user manager shared preference when driver sign in success
	 */
	
//	override fun storeDriverProfile(driverProfileEntity: DriverProfileEntity) {
//		val jsonValue = gson.toJson(driverProfileEntity)
//		userManagerPrefs.edit().putString(KEY_DRIVER_PROFILE, jsonValue).apply()
//	}
	
	/**
	 * This fun is for clear user data from user shared preference when logout success
	 */
	
	override fun clearUserData() {
		userManagerPrefs.edit()
				.remove(KEY_DRIVER_PROFILE)
				.remove(KEY_COMPANY_PAIRING)
				.remove(KEY_USER_SIGNED_IN)
				.remove(KEY_DESTINATION_LAT_LONG)
				.remove(KEY_TTA_PSA_MESSAGE_STATUS)
				.remove(KEY_MD5)
				.apply()
	}
	
	/**
	 * This fun set true on user shared preference if  sign in success else set false
	 */
	
	override fun setIsUserSignedIn(isSignedIn: Boolean) {
		userManagerPrefs.edit().putBoolean(KEY_USER_SIGNED_IN, isSignedIn).apply()
	}
	
	override fun storeCurrentShiftStatus(status: Boolean?) {
		if (status != null) {
			userManagerPrefs.edit().putBoolean(KEY_CURRENT_SHIFT, status).apply()
		}
	}
	
	/**
	 * for checking user sign in or not and then it will reply boolean value
	 */
	
//	override fun isUserSignedIn(): Boolean {
//		return userManagerPrefs.getBoolean(KEY_USER_SIGNED_IN, false)
//	}
	
	
//	override fun storeDriverDestinationBrani(lat: Double, lon: Double) {
//		val jsonValue = gson.toJson(LocationBody(lon, lat))
//		userManagerPrefs.edit().putString(KEY_DESTINATION_LAT_LONG, jsonValue).apply()
//	}
	
//	override fun storeDriverDestinationPasir(lat: Double, lon: Double) {
//		val jsonValue = gson.toJson(LocationBody(lon, lat))
//		userManagerPrefs.edit().putString(KEY_DESTINATION_LAT_LONG_TWO, jsonValue).apply()
//	}
//
//	override fun getDriverDestinationPortTwo(): LocationBody {
//		val jsonValue = userManagerPrefs.getString(KEY_DESTINATION_LAT_LONG_TWO, null)
//		return try {
//			gson.fromJson(jsonValue, LocationBody::class.java)
//		} catch (e: Exception) {
//			LocationBody(103.778497, 1.283016)
//		} catch (e: JsonParseException) {
//			LocationBody(103.778497, 1.283016)
//		}
//	}
//
//	override fun getDriverDestinationPort(): LocationBody {
//		val jsonValue = userManagerPrefs.getString(KEY_DESTINATION_LAT_LONG, null)
//		return try {
//			gson.fromJson(jsonValue, LocationBody::class.java)
//		} catch (e: Exception) {
//			LocationBody(103.826971, 1.266516)
//		} catch (e: JsonParseException) {
//			LocationBody(103.826971, 1.266516)
//		}
//	}
//
//	override fun setTtaPsaMessageStatus(status: Boolean) {
//		userManagerPrefs.edit().putBoolean(KEY_TTA_PSA_MESSAGE_STATUS, status).apply()
//	}
//
//	override fun getTtaPsaMessageStatus(): Boolean {
//		return userManagerPrefs.getBoolean(KEY_TTA_PSA_MESSAGE_STATUS, false)
//	}
	
}