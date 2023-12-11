package com.imtuc.stressid.view

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.imtuc.stressid.R
import com.imtuc.stressid.navigation.Screen
import com.imtuc.stressid.ui.theme.Background
import com.imtuc.stressid.ui.theme.StressIDTheme
import kotlinx.coroutines.delay

@Composable
fun SplashScreenActivity(navController: NavHostController) {
    var startAnimation by remember {
        mutableStateOf(false)
    }

    val alphaAnimation = animateFloatAsState(
        targetValue = if (startAnimation) { 1f } else { 0f },
        animationSpec = tween(
            durationMillis = 2000
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2000)
        navController.popBackStack()
        navController.navigate(Screen.PredictionForm.route)
    }

    SplashScreen(alphaAnimation.value)
}
@Composable
fun SplashScreen(alpha: Float) {
    Column(modifier = Modifier.background(color = Background)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .alpha(alpha)
                .padding(0.dp, 0.dp, 0.dp, 0.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "StressID Logo",
                modifier = Modifier
                    .width(250.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashPreview() {
    StressIDTheme {
        SplashScreen(1f)
    }
}