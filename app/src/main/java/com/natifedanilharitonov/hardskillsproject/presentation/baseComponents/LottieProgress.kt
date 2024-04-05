package com.natifedanilharitonov.hardskillsproject.presentation.baseComponents

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.natifedanilharitonov.hardskillsproject.R

@Composable
fun LottieProgress() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_animation))
    LottieAnimation(composition = composition)
}
