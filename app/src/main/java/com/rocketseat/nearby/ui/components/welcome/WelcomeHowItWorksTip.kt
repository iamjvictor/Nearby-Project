package com.rocketseat.nearby.ui.components.welcome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rocketseat.nearby.ui.theme.Gray500
import com.rocketseat.nearby.ui.theme.RedBase
import com.rocketseat.nearby.ui.theme.Typography

@Composable
fun WelcomeHowItWorksTip(modifier: Modifier = Modifier, title: String, subtitle: String, @DrawableRes iconRes: Int) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(16.dp))
    {
        Icon(
            modifier = Modifier.size(32.dp),
            painter = painterResource(id = iconRes),
            tint = RedBase,
            contentDescription = "Icone do como funciona"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(text = title, style = Typography.headlineSmall)
            Text(text = subtitle, style = Typography.bodyLarge, color = Gray500)
        }

    }

}