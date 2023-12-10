package com.imtuc.stressid.view

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.navigation.NavHostController
import com.imtuc.stressid.navigation.Screen
import com.imtuc.stressid.viewmodel.PredictionViewModel







@Composable
fun PredictionFormActivity(
    predictionViewModel: PredictionViewModel,
    lifecycleOwner: LifecycleOwner,
) {
    val context = LocalContext.current

    var anxietyLevel = remember {
        mutableStateOf("")
    }
    var selfEsteem = remember {
        mutableStateOf("")
    }
    var mentalHealthHistory = remember {
        mutableStateOf("")
    }
    var depression = remember {
        mutableStateOf("")
    }
    var headache = remember {
        mutableStateOf("")
    }
    var bloodPressure = remember {
        mutableStateOf("")
    }
    var sleepQuality = remember {
        mutableStateOf("")
    }
    var breathingProblem = remember {
        mutableStateOf("")
    }
    var noiseLevel = remember {
        mutableStateOf("")
    }
    var livingConditions = remember {
        mutableStateOf("")
    }
    var safety = remember {
        mutableStateOf("")
    }
    var basicNeeds = remember {
        mutableStateOf("")
    }
    var academicPerformance = remember {
        mutableStateOf("")
    }
    var studyLoad = remember {
        mutableStateOf("")
    }
    var teacherStudentRelationship = remember {
        mutableStateOf("")
    }
    var futureCareerConcerns = remember {
        mutableStateOf("")
    }
    var socialSupport = remember {
        mutableStateOf("")
    }
    var peerPressure = remember {
        mutableStateOf("")
    }
    var extracurricularActivities = remember {
        mutableStateOf("")
    }
    var bullying = remember {
        mutableStateOf("")
    }
    var result = remember{
        mutableStateOf(false)
    }
    var showResult = remember{
        mutableStateOf("")
    }

    predictionViewModel.prediction.observe(lifecycleOwner, Observer {
            response ->
        showResult.value = predictionViewModel.prediction.toString()
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TextField(
            value = anxietyLevel.value,
            onValueChange = { anxietyLevel.value = it },
            label = { Text("Anxiety Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = selfEsteem.value,
            onValueChange = { selfEsteem.value = it },
            label = { Text("Self Esteem Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = mentalHealthHistory.value,
            onValueChange = { mentalHealthHistory.value = it },
            label = { Text("Mental Health Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = depression.value,
            onValueChange = { depression.value = it },
            label = { Text("Depression Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = headache.value,
            onValueChange = { headache.value = it },
            label = { Text("Headache Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = bloodPressure.value,
            onValueChange = { bloodPressure.value = it },
            label = { Text("bloodPressure Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = sleepQuality.value,
            onValueChange = { sleepQuality.value = it },
            label = { Text("sleepQuality Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = breathingProblem.value,
            onValueChange = { breathingProblem.value = it },
            label = { Text("breathingProblem Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = noiseLevel.value,
            onValueChange = { noiseLevel.value = it },
            label = { Text("noiseLevel Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = livingConditions.value,
            onValueChange = { livingConditions.value = it },
            label = { Text("livingConditions Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = safety.value,
            onValueChange = { safety.value = it },
            label = { Text("safety Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = basicNeeds.value,
            onValueChange = { basicNeeds.value = it },
            label = { Text("basicNeeds Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = academicPerformance.value,
            onValueChange = { academicPerformance.value = it },
            label = { Text("academicPerformance Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = studyLoad.value,
            onValueChange = { studyLoad.value = it },
            label = { Text("studyLoad Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = teacherStudentRelationship.value,
            onValueChange = { teacherStudentRelationship.value = it },
            label = { Text("teacherStudentRelationship Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = futureCareerConcerns.value,
            onValueChange = { futureCareerConcerns.value = it },
            label = { Text("futureCareerConcerns Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = socialSupport.value,
            onValueChange = { socialSupport.value = it },
            label = { Text("socialSupport Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = peerPressure.value,
            onValueChange = { peerPressure.value = it },
            label = { Text("peerPressure Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = extracurricularActivities.value,
            onValueChange = { extracurricularActivities.value = it },
            label = { Text("extracurricularActivities Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        TextField(
            value = bullying.value,
            onValueChange = { bullying.value = it },
            label = { Text("bullying Level") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )



        Button(
            onClick = {
                predictionViewModel.predict(
                    anxietyLevel.value.toInt(),
                    selfEsteem.value.toInt(),
                    mentalHealthHistory.value.toInt(),
                    depression.value.toInt(),
                    headache.value.toInt(),
                    bloodPressure.value.toInt(),
                    sleepQuality.value.toInt(),
                    breathingProblem.value.toInt(),
                    noiseLevel.value.toInt(),
                    livingConditions.value.toInt(),
                    safety.value.toInt(),
                    basicNeeds.value.toInt(),
                    academicPerformance.value.toInt(),
                    studyLoad.value.toInt(),
                    teacherStudentRelationship.value.toInt(),
                    futureCareerConcerns.value.toInt(),
                    socialSupport.value.toInt(),
                    peerPressure.value.toInt(),
                    extracurricularActivities.value.toInt(),
                    bullying.value.toInt(),
                    )
                result.value = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Check")
        }

        if (result.value == true){
            Text("${showResult}")
        }



    }
}