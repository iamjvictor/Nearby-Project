package com.rocketseat.nearby.ui.screen.viewModel.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.maps.model.LatLng
import com.rocketseat.nearby.data.model.Category
import com.rocketseat.nearby.data.model.Market
import com.rocketseat.nearby.data.model.mock.MockDataService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun onEvent(event: HomeUiEvent) {
        when (event) {
            is HomeUiEvent.OnFetchCategories -> fetchCategories()
            is HomeUiEvent.OnFetchMarkets -> fetchMarkets(categoryId = event.categoryId)
            else -> {
                Log.e("HomeViewModel", "Unknown event: $event")
            }
        }
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val categories = MockDataService.getMockCategories()
                _uiState.update { currentUiState ->
                    currentUiState.copy(categories = categories)
                }
                Log.d("HomeViewModel", "Categories fetched: ${categories.size}")
            } catch (error: Exception) {
                _uiState.update { currentUiState ->
                    currentUiState.copy(categories = emptyList())
                }
                Log.e("HomeViewModel", "Failed to fetch categories", error)
            }
        }
    }

    private fun fetchMarkets(categoryId: String) {
        viewModelScope.launch {
            val markets = MockDataService.getMockMarkets(categoryId)
            _uiState.update { currentUiState ->
                currentUiState.copy(
                    markets = markets,
                    marketLocations = markets.map { market ->
                        LatLng(market.latitude, market.longitude)
                    }
                )
            }
            Log.d("HomeViewModel", "Mock markets fetched: ${markets.size}")
        }
    }
}




