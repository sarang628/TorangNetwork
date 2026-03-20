package com.sarang.torang.api

import com.sarang.torang.data.remote.response.AlarmApiModel
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface ApiAlarm {
    /**
     * 알람 불러오기
     */
    @GET("findAll")
    suspend fun findAll(@Header("authorization") auth: String): Response<List<AlarmApiModel>>

    /**
     * 알람 삭제하기
     */
    @DELETE("{alarmId}")
    suspend fun delete(
        @Header("authorization") auth: String,
        @Path("alarmId") alarmId: Int
    ): Response<Unit>
}