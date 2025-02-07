package com.rocketseat.nearby.ui.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rocketseat.nearby.R
import com.rocketseat.nearby.ui.components.button.NearbyButton
import com.rocketseat.nearby.ui.components.welcome.WelcomeBody
import com.rocketseat.nearby.ui.components.welcome.WelcomeHeader
import com.rocketseat.nearby.ui.theme.Gray500
import com.rocketseat.nearby.ui.theme.RedBase
import com.rocketseat.nearby.ui.theme.Typography

@Composable
fun WelcomeScreen(modifier: Modifier = Modifier, onNavigateToHome: () -> Unit) {
    Column(
        modifier = modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(horizontal = 40.dp, vertical = 48.dp)
            .verticalScroll(state = rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        WelcomeHeader()
        WelcomeBody()
        NearbyButton(modifier = Modifier.fillMaxWidth(),
            text = "Começar",
            onClick = {
                onNavigateToHome()
            })

    }


}


@Preview
@Composable
private fun WelcomeScreenPrewiew() {
    WelcomeScreen(onNavigateToHome = {})
}