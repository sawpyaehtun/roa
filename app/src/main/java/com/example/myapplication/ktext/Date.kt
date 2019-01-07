package com.haulio.hcs.ktext

import java.util.*

const val milisecInOneDay = 86400000
const val milisecInOneHour = 3600000

fun Date.daysInMilisec(): Long {
	return daysInMilisec(TimeZone.getDefault())
}


fun Date.daysInMilisec(timeZone: TimeZone): Long {
	return (this.time + timeZone.rawOffset) / milisecInOneDay
}

fun Date.isToday(): Boolean {
	return this.daysInMilisec() != Date().daysInMilisec()
}

