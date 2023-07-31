package com.example.animeworldjetpackcompose.ui.features.splash

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.animeworldjetpackcompose.R
import com.example.animeworldjetpackcompose.ui.companent.BaseScreen
import kotlinx.coroutines.delay

/**
 * @author mvn-toan.nguyen2 on 7/25/23
 **/

@ExperimentalFoundationApi
@Composable
fun SplashScreen(onNextScreen: () -> Unit) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.animation_hello))

    LaunchedEffect(key1 = true) {
        delay(2000)
        onNextScreen.invoke()
    }
    BaseScreen(contentAlignment = Alignment.Center) {
        LottieAnimation(composition = composition)
    }
}
