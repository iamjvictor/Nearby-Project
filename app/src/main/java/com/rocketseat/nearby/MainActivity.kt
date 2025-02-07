package com.rocketseat.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.rocketseat.nearby.data.model.Market

import com.rocketseat.nearby.ui.screen.SplashScreen
import com.rocketseat.nearby.ui.screen.WelcomeScreen
import com.rocketseat.nearby.ui.screen.HomeScreen

import com.rocketseat.nearby.ui.screen.route.Home
import com.rocketseat.nearby.ui.screen.route.Splash
import com.rocketseat.nearby.ui.screen.route.Welcome
import com.rocketseat.nearby.ui.screen.viewModel.marketDetails.MarketDetailsViewModel
import com.rocketseat.nearby.ui.theme.NearbyTheme


import com.rocketseat.nearby.ui.screen.viewModel.home.HomeViewModel
import com.rocketseat.nearby.ui.screen.MarketDetailsScreen
import com.rocketseat.nearby.ui.screen.qrcode_scanner.QRCodeScannerScreen
import com.rocketseat.nearby.ui.screen.route.QRCodeScanner
import com.rocketseat.nearby.ui.screen.viewModel.marketDetails.MarketDetailsUiEvent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NearbyTheme {
                val navController = rememberNavController()


                val homeViewModel by viewModels<HomeViewModel>()
                val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                val marketDetailsViewModel by viewModels<MarketDetailsViewModel>()
                val marketDetailsUiState by marketDetailsViewModel.uiState.collectAsStateWithLifecycle()
                NavHost(
                    navController = navController,
                    startDestination = Splash
                ){
                    composable<Splash>{
                        SplashScreen(
                            onNavigateToWelcome = {
                                navController.navigate(Welcome)
                            })
                    }
                    composable<Welcome>{
                        WelcomeScreen(onNavigateToHome={
                            navController.navigate(Home)
                        })
                    }
                    composable<Home> {
                        HomeScreen(
                            onNavigateToMarketDetails = { selectedMarket ->
                                navController.navigate(selectedMarket)
                            },
                            uiState = homeUiState,
                            onEvent = homeViewModel::onEvent
                        )
                    }
                    composable<Market> {
                        val selectedMarket = it.toRoute<Market>()

                        MarketDetailsScreen(
                            market = selectedMarket,
                            uiState = marketDetailsUiState,
                            onEvent = marketDetailsViewModel::onEvent,
                            onNavigateBack = {
                                navController.popBackStack()
                            },
                            onNavigateToQRCodeScanner = {
                                navController.navigate(QRCodeScanner)
                            }
                        )
                    }
                    composable<QRCodeScanner> {
                        QRCodeScannerScreen(
                            onCompletedScan = { qrCodeContent ->
                                if (qrCodeContent.isNotEmpty()) {
                                    marketDetailsViewModel.onEvent(
                                        MarketDetailsUiEvent.OnFetchCoupon(
                                            qrCodeContent
                                        )
                                    )
                                    navController.popBackStack()
                                }
                            }
                        )
                    }
                }

            }
        }
    }
}


