package com.itecknologi.maintenancepage

data class Model(
    val maintenanceName: Int,
    val progress: Int,
    val progressType: progressType
)

enum class progressType {
    KM, MONTH
}

var oil: Int? = null
var tyres: Int? = null
