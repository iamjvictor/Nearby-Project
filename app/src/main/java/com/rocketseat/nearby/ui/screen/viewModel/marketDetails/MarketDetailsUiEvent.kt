package com.rocketseat.nearby.ui.screen.viewModel.marketDetails

sealed class MarketDetailsUiEvent {
    data class OnFetchRules(val marketId: String) : MarketDetailsUiEvent()
    data class OnFetchCoupon(val qrCodeContent: String) : MarketDetailsUiEvent()
    data object OnResetCoupon : MarketDetailsUiEvent()
}