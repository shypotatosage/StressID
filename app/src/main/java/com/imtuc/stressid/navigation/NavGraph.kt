package com.imtuc.stressid.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.imtuc.stressid.view.PredictionFormActivity
import com.imtuc.stressid.view.SplashScreenActivity

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    lifecycleOwner: LifecycleOwner
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(
            route = Screen.Splash.route
        ) {
            SplashScreenActivity(navController = navController)
        }

        composable(
            route = Screen.PredictionForm.route
        ) {
            PredictionFormActivity()
        }
    }
}