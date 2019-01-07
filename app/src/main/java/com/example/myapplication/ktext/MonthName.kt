package com.haulio.hcs.ktext

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap


fun Int.toMonthName(): String {
	val cal = Calendar.getInstance()
	val monthDate = SimpleDateFormat("MMM", Locale.ENGLISH)
	cal.set(Calendar.MONTH, this)
	return monthDate.format(cal.time)
}


fun HashMap<String, String>.toJsonObject(): JsonObject {
	val mGson = GsonBuilder().setPrettyPrinting().create()
	val jsonObject: JsonObject
	val jsonParser = JsonParser()
	jsonObject = jsonParser.parse(mGson.toJson(this)).asJsonObject
	return jsonObject
}
