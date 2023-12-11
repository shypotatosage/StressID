package com.imtuc.stressid.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.imtuc.stressid.navigation.Screen
import com.imtuc.stressid.ui.theme.Purple40
import com.imtuc.stressid.ui.theme.StressIDTheme
import com.imtuc.stressid.viewmodel.PredictionViewModel

@Composable
fun ResultActivity(prediction: String, navController: NavHostController) {
    var prediction = remember {
        mutableStateOf(prediction)
    }

    val resultText = when (prediction.value) {
        "0" -> "You're good!"
        "1" -> "You're starting to feel stressed out, please make sure to have enough rest!"
        "2" -> "You're not in good condition, seek help immediately!"
        else -> "Unknown result"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Stress Level",
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = prediction.value,
            style = TextStyle(
                fontSize = 32.sp,
                color = Purple40,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = resultText,
            style = TextStyle(
                fontSize = 26.sp
            ),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Screen.PredictionForm.route)
            },
            modifier = Modifier
                .padding(0.dp, 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Purple40, contentColor = Color.Black),
        ) {
            Text(
                "Return",
                style = TextStyle(
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    color = Color.White
                ),
                modifier = Modifier.padding(16.dp, 0.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultPreview() {
    StressIDTheme {
        ResultActivity("0", rememberNavController())
    }
}