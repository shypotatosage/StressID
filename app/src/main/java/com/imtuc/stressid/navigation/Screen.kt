package com.imtuc.stressid.navigation

sealed class Screen(val route: String) {
    object Splash:Screen(route = "splash_screen")
    object PredictionForm:Screen(route = "prediction_form")
}