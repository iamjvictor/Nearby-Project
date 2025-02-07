package com.rocketseat.nearby.ui.screen.viewModel.home

import com.google.android.gms.maps.model.LatLng
import com.rocketseat.nearby.data.model.Category
import com.rocketseat.nearby.data.model.Market

data class HomeUiState(
    val categories: List<Category>? = null,
    val markets: List<Market>? = null,
    val marketLocations: List<LatLng>? = null
)

