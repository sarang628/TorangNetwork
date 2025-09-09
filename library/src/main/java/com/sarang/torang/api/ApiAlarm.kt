package com.sarang.torang.api

import com.sarang.torang.data.remote.response.AlarmAlarmModel
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiAlarm {
    @POST("getAlarms") suspend fun getAlarms(@Header("authorization") auth: String): ArrayList<AlarmAlarmModel>
}