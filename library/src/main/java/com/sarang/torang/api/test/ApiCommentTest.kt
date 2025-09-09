package com.sarang.torang.api.test

/*@Composable
fun ApiCommentTest(apiComment: ApiComment, sessionService: SessionService?) {
    val coroutine = rememberCoroutineScope()
    Column {
        Text(text = "ApiCommentTest", fontSize = 21.sp, fontWeight = FontWeight.Bold)
        sessionService?.let {
            AddComment(apiComment, sessionService)
            DeleteComment(apiComment, sessionService)
            GetComment(apiComment, sessionService)
            GetCommentsWithOneReply(apiComment, sessionService)
            LoadMore(apiComment, sessionService)
        }
    }
}*/

/*@Composable
internal fun AddComment(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        coroutine.launch {
            try {
                apiComment.addComment(
                    review_id = 329,
                    auth = sessionService.getToken()!!,
                    comment = "ㅋㅋㅋㅋㅋㅋ",
                    parentCommentId = 145,
                    tagUserId = 1
                )
            } catch (e: Exception) {
                Log.e("ApiCommentTest", e.message.toString())
            }
        }
    }) {
        Text(text = "add")
    }
}*/

/*@Composable
internal fun DeleteComment(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        coroutine.launch {
            apiComment.deleteComment(1)
        }
    }) {
        Text(text = "delete")
    }
}*/

/*
@Composable
internal fun GetComment(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    Button(onClick = {
        sessionService.getToken()?.let {
            coroutine.launch {
                val list = apiComment.getComments(it, 82)
                Log.d("ApiCommentTest", list.toString())
            }
        }
    }) {
        Text(text = "get")
    }
}
*/

/*
@Composable
internal fun GetCommentsWithOneReply(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    var list by remember { mutableStateOf(CommentListApiModel("", list = listOf())) }
    var error by remember { mutableStateOf("") }
    Button(onClick = {
        sessionService.getToken().let {
            if (it == null) {
                error = "로그인을 해주세요."
            } else {
                coroutine.launch {
                    list = apiComment.getCommentsWithOneReply(it, 329)
                    Log.d("ApiCommentTest", list.toString())
                }
            }
        }
    }) {
        Text(text = "GetCommentWithReply")
    }
    Column {
        for (item in list.list) {
            item.ToComposable()
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    Text(text = error)
}
*/

/*
@Composable
internal fun LoadMore(apiComment: ApiComment, sessionService: SessionService) {
    val coroutine = rememberCoroutineScope()
    var list: List<RemoteComment> by remember { mutableStateOf(ArrayList()) }
    var error by remember { mutableStateOf("") }
    Button(onClick = {
        sessionService.getToken().let {
            if (it == null) {
                error = "로그인을 해주세요."
            } else {
                coroutine.launch {
                    list = apiComment.getSubComments(it, 249)
                    Log.d("ApiCommentTest", list.toString())
                }
            }
        }
    }) {
        Text(text = "LoadMore")
    }
    Column {
        for (item in list) {
            item.ToComposable()
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    Text(text = error)
}*/
