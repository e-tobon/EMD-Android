package com.avv.cardiologoapp.data

import com.google.gson.annotations.SerializedName

data class cardioValue(
    var IMU: imu
)

data class imu(
    @SerializedName("BPM:")
    val BPM: Float?,
    @SerializedName("Inclinacion X:")
    val InclinacionX: Float?,
    @SerializedName("Inclinacion y:")
    val InclinacionY: Float?,
    @SerializedName("Inclinacion z:")
    val InclinacionZ: Float?,
    @SerializedName("Temperatura:")
    val temperatura: Float?


)

