package com.rocketseat.nearby.ui.screen.viewModel.home

sealed class HomeUiEvent{
    data object OnFetchCategories: HomeUiEvent()
    data class OnFetchMarkets(val categoryId: String): HomeUiEvent()
}