package com.haulio.hcs.ui

import java.util.*

val NRIC_PATTERN = Regex("[SFTG]\\d{7}[A-Z]")
val PHONE_PATTERN_SG = Regex("[89]\\d{7}")
val PHONE_PATTERN_OTHERS = Regex("^[0-9]+\$")
val CONTAINER_PATTERN = Regex("^[A-Z]{4}\\d{7}")
const val SG_COUNTRY_CODE = "sg"

const val DATE_FORMAT_REGISTRATION_DOB = "dd/MM/yyyy"
const val DATE_FORMAT_PROFILE_DOB = "dd MMMM yyyy"
const val DATE_FORMAT_PROFILE_DOB_CHINESE = "yyyy年 MM月 dd日"
const val DATE_FORMAT_PAIRING = "dd MMMM yyyy"
const val DATE_FORMAT_TODAY_DISPLAY_TEXT = "EEEE, dd MMMM yyyy"
const val DATE_FORMAT_TODAY_DISPLAY_TEXT_CHINESE = "EEEE, yyyy年 MM月 dd日"
const val DATE_FORMAT_RECEIVED_TIME = "hh:mma"
const val DATE_FORMAT_CHAT_DATETIME = "EEE, dd MMM"
const val DATE_FORMAT_SURCHARGE_COMPLETION_DATE = "EEEE, dd MMMM yyyy"
const val DATE_FORMAT_JOB_TIME = "hh:mma"
const val NUM_FORMAT_PRICING = "%.2f"

//PSA related message
const val PRE_GATE_ENQUIRY = "Pre-gate Enquiry"
const val DL_DD_ENQUIRY = "DL/DD Enquiry"
const val CONTAINER_SURVEY = "Container Survey"
const val IN_POSITION = "In Position"
const val COMMON_KEY = "title"
const val UPDATE_OR_FORGOT = "update or forgot"
const val FORGOT_PASSWORD = "forgotpassword"
val APP_LANGUAGES = listOf(Locale.ENGLISH, Locale.CHINESE)