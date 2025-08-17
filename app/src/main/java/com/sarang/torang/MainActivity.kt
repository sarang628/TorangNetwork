package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sarang.torang.api.ApiAlarm
import com.sarang.torang.api.ApiComment
import com.sarang.torang.api.ApiCommentLike
import com.sarang.torang.api.ApiLike
import com.sarang.torang.api.ApiRestaurant
import com.sarang.torang.api.ApiReview
import com.sarang.torang.api.feed.ApiFeed
import com.sarang.torang.ui.theme.TorangNetworkTheme
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //apis
    @Inject lateinit var apiFeed        : ApiFeed
    @Inject lateinit var apiComment     : ApiComment
    @Inject lateinit var apiReview      : ApiReview
    @Inject lateinit var apiAlarm       : ApiAlarm
    @Inject lateinit var apiLike        : ApiLike
    @Inject lateinit var apiRestaurant  : ApiRestaurant
    @Inject lateinit var apiCommentLike : ApiCommentLike

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TorangTheme {
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    ApiTest(
                        //apiLike = apiLike,
                        //apiFeed = apiFeed,
                        //apiComment = apiComment,
                        //sessionService = sessionService,
                        //apiRestaurant = apiRestaurant,
                        //apiReview = apiReview,
                        //apiAlarm = apiAlarm,
                        //apiCommentLike = apiCommentLike,
                        //sessionClientService = sessionClientService
                    )
                }
            }
        }
    }
}