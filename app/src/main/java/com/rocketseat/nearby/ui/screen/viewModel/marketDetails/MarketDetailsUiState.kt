package com.rocketseat.nearby.ui.screen.viewModel.marketDetails


import com.rocketseat.nearby.data.model.Rule

data class MarketDetailsUiState(
    val rules: List<Rule>? = null,
    val coupon: String? = null,
)