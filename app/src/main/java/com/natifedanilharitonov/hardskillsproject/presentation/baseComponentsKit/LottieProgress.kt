package com.natifedanilharitonov.hardskillsproject.presentation.baseComponentsKit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.natifedanilharitonov.hardskillsproject.R
import com.natifedanilharitonov.hardskillsproject.utils.TestTags.PENDING_TAG

@Composable
fun LottieProgress() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_animation))
    LottieAnimation(composition = composition, modifier = Modifier.testTag(PENDING_TAG))
}
