package com.rocketseat.nearby.ui.screen

import android.window.SplashScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.rocketseat.nearby.R
import com.rocketseat.nearby.ui.theme.GreenLight
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, onNavigateToWelcome: () -> Unit) {
    LaunchedEffect(key1 = Unit) {
        delay(3_000)
        onNavigateToWelcome()
    }

    Box(
        modifier = modifier
            .background(GreenLight)
            .fillMaxSize(),
    ) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.img_logo_logo_logo_text),
            contentDescription ="Imagem logo"
        )
        Image(
            modifier = Modifier.align(Alignment.BottomCenter),
            painter = painterResource(id = R.drawable.bg_splash_screen),
            contentDescription ="Imagem Background"
        )
    }

}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen(onNavigateToWelcome = {})
}