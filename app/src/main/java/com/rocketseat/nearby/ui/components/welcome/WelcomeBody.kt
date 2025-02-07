package com.rocketseat.nearby.ui.components.welcome

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rocketseat.nearby.R
import com.rocketseat.nearby.ui.theme.Typography

@Composable
fun WelcomeBody(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {
        Text(text = "Veja como funciona:", style = Typography.bodyLarge)

        WelcomeHowItWorksTip(modifier = Modifier.fillMaxWidth(),
            title = "Encontre estabelecimentos perto de você",
            subtitle = "Veja locais perto de você",
            iconRes = R.drawable.ic_map_pin)
        WelcomeHowItWorksTip(modifier = Modifier.fillMaxWidth(),
            title = "Ative cupom com QR Code",
            subtitle = "Escaneie o código no Estabelecimento para ganhar beneficios",
            iconRes = R.drawable.ic_qrcode)
        WelcomeHowItWorksTip(modifier = Modifier.fillMaxWidth(),
            title ="Garanta vantagens",
            subtitle = "Ative cupons de qualquer lugar, em vários tipos de estabelecimentos",
            iconRes = R.drawable.ic_ticket)
    }

}