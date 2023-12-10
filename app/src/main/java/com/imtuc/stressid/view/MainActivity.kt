package com.imtuc.stressid.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.imtuc.stressid.navigation.SetupNavGraph

import com.imtuc.stressid.ui.theme.StressIDTheme
import com.imtuc.stressid.viewmodel.PredictionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var predictionViewModel: PredictionViewModel
    lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        predictionViewModel = ViewModelProvider(this)[PredictionViewModel::class.java]

        setContent {
            StressIDTheme {
                navController = rememberNavController()

                SetupNavGraph(
                    navController = navController,
                    predictionViewModel = predictionViewModel,
                    lifecycleOwner = this
                )
            }
        }
    }
}
