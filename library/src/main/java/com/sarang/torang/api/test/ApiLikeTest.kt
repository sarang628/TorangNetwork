package com.sarang.torang.api.test

/*
@Composable
fun ApiLikeTest(
    apiLike: ApiLike,
    sessionService: SessionService,
) {
    var result by remember { mutableStateOf("") }
    val coroutine = rememberCoroutineScope()
    Column {
        Button(onClick = {
            coroutine.launch {
                val token = sessionService.getToken()
                if (token == null) {
                    result = "로그인을 해주세요."
                } else {
                    try {
                        result = GsonBuilder().setPrettyPrinting().create()
                            .toJson(apiLike.getLikeUserByReviewId(token, "399"))
                    } catch (e: Exception) {
                        result = e.message.toString()
                    }
                }

            }
        }) {

        }
        Text(text = result)
    }

}*/