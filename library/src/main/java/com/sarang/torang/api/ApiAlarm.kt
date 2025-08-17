package com.sarang.torang.api

import com.sarang.torang.data.remote.response.AlarmAlarmModel
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiAlarm {
    @POST("getAlarms")
    suspend fun getAlarms(@Header("authorization") auth: String): ArrayList<AlarmAlarmModel>
}

/*
@Composable
fun ApiAlarmTest(apiAlarm: ApiAlarm, sessionService: SessionService) {
    var result by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()

    Column {
        Button(onClick = {
            coroutine.launch {
                sessionService.getToken()?.let {
                    Log.d("ApiAlarmTest", it)
                    result = apiAlarm.getAlarms(it).toString()
                }
            }
        }) {
            Text(text = "")
        }
        Text(text = result)
    }
}*/
