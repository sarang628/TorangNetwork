package com.sarang.torang.api.test

/*
@Composable
fun ApiCommentLikeTest(
    apiCommentLike: ApiCommentLike,
    sessionClientService: SessionClientService? = null
) {
    var result by remember { mutableStateOf("") }
    var comments: List<CommentLikeApiModel> by remember { mutableStateOf(ArrayList()) }
    val coroutine = rememberCoroutineScope()
    val height = LocalConfiguration.current.screenHeightDp
    val auth = sessionClientService?.getToken() ?: ""
    var commentId by remember { mutableStateOf("0") }
    Column {
        Text(text = "ApiCommentLikeTest", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(20.dp))
        Row(modifier = Modifier.height(height.dp)) {
            Column(Modifier.weight(0.3f)) {
                Button(onClick = {
                    coroutine.launch {
                        try {
                            comments =
                                apiCommentLike.getAllCommentLike(auth = auth)
                        } catch (e: Exception) {
                            result = e.toString()
                        }

                    }
                }) {
                    Text(text = "getAllCommentLike")
                }
                Button(onClick = {
                    coroutine.launch {
                        try {
                            result =
                                apiCommentLike.addCommentLike(auth, commentId = commentId.toInt())
                                    .toString()
                            comments = apiCommentLike.getAllCommentLike(auth)
                        } catch (e: Exception) {
                            result = e.toString()
                        }

                    }
                }) {
                    Column {
                        Text(text = "addCommentLike")
                        TextField(value = commentId, onValueChange = {
                            commentId = it
                        })
                    }

                }
                Button(onClick = {
                    coroutine.launch {
                        try {
                            result =
                                apiCommentLike.deleteCommentLike(
                                    auth,
                                    commentId.toInt()
                                )
                                    .toString()
                            comments = apiCommentLike.getAllCommentLike(auth)
                        } catch (e: Exception) {
                            result = e.toString()
                        }

                    }
                }) {
                    Column {
                        Text(text = "deleteCommentLike")
                        TextField(value = commentId, onValueChange = {
                            commentId = it
                        })
                    }
                }
                Text(text = "result ${result}")
            }
            Column(
                Modifier
                    .weight(0.7f)
            ) {
                LazyColumn(content = {
                    items(comments.size) {
                        Card(Modifier.padding(10.dp)) {
                            Column {
                                Text(text = comments[it].toString())
                                Button(onClick = {
                                    coroutine.launch {
                                        try {
                                            apiCommentLike.deleteCommentLike(
                                                auth = auth,
                                                commentId = comments[it].commentId
                                            )
                                            comments = apiCommentLike.getAllCommentLike(auth)
                                        } catch (e: Exception) {


                                        }
                                    }
                                }) {
                                    Text(text = "Delete")
                                }
                            }
                        }
                    }
                })
            }
        }
    }

}*/