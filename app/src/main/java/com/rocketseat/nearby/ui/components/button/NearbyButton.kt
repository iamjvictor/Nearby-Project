package com.rocketseat.nearby.ui.components.button


import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rocketseat.nearby.R
import com.rocketseat.nearby.ui.theme.GreenBase
import com.rocketseat.nearby.ui.theme.Typography

@Composable
fun NearbyButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    @DrawableRes iconRes: Int? = null,
    onClick: () -> Unit
) {
    Button(modifier = modifier.heightIn(min = 56.dp),
        shape = RoundedCornerShape(16.dp),
        contentPadding = if (text == null && iconRes != null) PaddingValues(0.dp) else ButtonDefaults.ContentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenBase
        ),
        onClick = onClick) {
        Row(
            verticalAlignment = Alignment.CenterVertically,

            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            iconRes?.let {
                Icon(painter = painterResource(id = iconRes), contentDescription = "ICONE DO BOTÃO")
            }
            text?.let { Text(text = text.uppercase(), style = Typography.labelLarge) }
        }
    }
}

@Preview
@Composable
private fun NearbyButtonPrewiew() {
    NearbyButton(modifier = Modifier.fillMaxWidth(),
        text = "Confirmar",
        iconRes = R.drawable.ic_scan) {
    }
}

@Preview
@Composable
private fun NearbyButtonNoTextPrewiew() {
    NearbyButton(modifier = Modifier,
        iconRes = R.drawable.ic_arrow_left) {

    }
}

@Preview
@Composable
private fun NearbyButtonNoIconPrewiew() {
    NearbyButton(modifier = Modifier.fillMaxWidth(),
        text = "Confirmar",
        ) {

    }
}