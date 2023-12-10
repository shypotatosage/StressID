package com.imtuc.stressid.view

import android.R
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.imtuc.stressid.viewmodel.PredictionViewModel
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp


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

    var expanded by remember {
        mutableStateOf(false)
    }

    var expanded_sE by remember {
        mutableStateOf(false)
    }

    var expanded_ap by remember {
        mutableStateOf(false)
    }
    var expanded_bn by remember {
        mutableStateOf(false)
    }
    var expanded_b by remember {
        mutableStateOf(false)
    }
    var expanded_bp by remember {
        mutableStateOf(false)
    }
    var expanded_nl by remember {
        mutableStateOf(false)
    }
    var expanded_s by remember {
        mutableStateOf(false)
    }
    var expanded_d by remember {
        mutableStateOf(false)
    }
    var expanded_ea by remember {
        mutableStateOf(false)
    }
    var expanded_fcc by remember {
        mutableStateOf(false)
    }
    var expanded_h by remember {
        mutableStateOf(false)
    }
    var expanded_lc by remember {
        mutableStateOf(false)
    }
    var expanded_mH by remember {
        mutableStateOf(false)
    }
    var expanded_pp by remember {
        mutableStateOf(false)
    }
    var expanded_sl by remember {
        mutableStateOf(false)
    }
    var expanded_sq by remember {
        mutableStateOf(false)
    }
    var expanded_ss by remember {
        mutableStateOf(false)
    }
    var expanded_tsr by remember {
        mutableStateOf(false)
    }

    predictionViewModel.prediction.observe(lifecycleOwner, Observer {
            response ->
        showResult.value = predictionViewModel.prediction.value.toString()
        result.value = true
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Anxiety Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded = !expanded } // Toggle dropdown on click
        ) {
            Text(
                text = "${anxietyLevel.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..21) {
                DropdownMenuItem(onClick = {
                    anxietyLevel.value = i.toString()
                    expanded = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }

        Text("Self Esteem Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_sE = !expanded_sE } // Toggle dropdown on click
        ) {
            Text(
                text = "${selfEsteem.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_sE,
            onDismissRequest = { expanded_sE = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..30) {
                DropdownMenuItem(onClick = {
                    selfEsteem.value = i.toString()
                    expanded_sE = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }

        Text("Mental Health History:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_mH = !expanded_mH } // Toggle dropdown on click
        ) {
            Text(
                text = "${mentalHealthHistory.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_mH,
            onDismissRequest = { expanded_mH = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..1) {
                DropdownMenuItem(onClick = {
                    mentalHealthHistory.value = i.toString()
                    expanded_mH = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }

        Text("Depression Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_d = !expanded_d } // Toggle dropdown on click
        ) {
            Text(
                text = "${depression.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_d,
            onDismissRequest = { expanded_d = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..27) {
                DropdownMenuItem(onClick = {
                    depression.value = i.toString()
                    expanded_d = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }


        Text("Headache Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_h = !expanded_h } // Toggle dropdown on click
        ) {
            Text(
                text = "${headache.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_h,
            onDismissRequest = { expanded_h = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    headache.value = i.toString()
                    expanded_h = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }

        Text("Sleep Quality Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_sq = !expanded_sq } // Toggle dropdown on click
        ) {
            Text(
                text = "${sleepQuality.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_sq,
            onDismissRequest = { expanded_sq = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    sleepQuality.value = i.toString()
                    expanded_sq = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }

        Text("Breathing Problem Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_bp = !expanded_bp } // Toggle dropdown on click
        ) {
            Text(
                text = "${breathingProblem.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_bp,
            onDismissRequest = { expanded_bp = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    breathingProblem.value = i.toString()
                    expanded_bp = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }

        Text("Noise Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_nl = !expanded_nl } // Toggle dropdown on click
        ) {
            Text(
                text = "${noiseLevel.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_nl,
            onDismissRequest = { expanded_nl = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    noiseLevel.value = i.toString()
                    expanded_nl = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }

        Text("living Conditions Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_lc = !expanded_lc } // Toggle dropdown on click
        ) {
            Text(
                text = "${livingConditions.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_lc,
            onDismissRequest = { expanded_lc = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    livingConditions.value = i.toString()
                    expanded_lc = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("Safety Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_s = !expanded_s } // Toggle dropdown on click
        ) {
            Text(
                text = "${safety.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_s,
            onDismissRequest = { expanded_s = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    safety.value = i.toString()
                    expanded_s = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("basic Needs Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_bn = !expanded_bn } // Toggle dropdown on click
        ) {
            Text(
                text = "${basicNeeds.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_bn,
            onDismissRequest = { expanded_bn = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    basicNeeds.value = i.toString()
                    expanded_bn = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("academic Performances Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_ap = !expanded_ap } // Toggle dropdown on click
        ) {
            Text(
                text = "${academicPerformance.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_ap,
            onDismissRequest = { expanded_ap = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    academicPerformance.value = i.toString()
                    expanded_ap = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("study Load Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_sl = !expanded_sl } // Toggle dropdown on click
        ) {
            Text(
                text = "${studyLoad.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_sl,
            onDismissRequest = { expanded_sl = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    studyLoad.value = i.toString()
                    expanded_sl = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("teacher Student Relationship Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_tsr = !expanded_tsr } // Toggle dropdown on click
        ) {
            Text(
                text = "${teacherStudentRelationship.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_tsr,
            onDismissRequest = { expanded_tsr = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    teacherStudentRelationship.value = i.toString()
                    expanded_tsr = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("future Career Concerns Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_fcc = !expanded_fcc } // Toggle dropdown on click
        ) {
            Text(
                text = "${futureCareerConcerns.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_fcc,
            onDismissRequest = { expanded_fcc = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    futureCareerConcerns.value = i.toString()
                    expanded_fcc = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("social Support Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_ss = !expanded_ss } // Toggle dropdown on click
        ) {
            Text(
                text = "${socialSupport.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_ss,
            onDismissRequest = { expanded_ss = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    socialSupport.value = i.toString()
                    expanded_ss = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("Peer Pressure Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_pp = !expanded_pp } // Toggle dropdown on click
        ) {
            Text(
                text = "${peerPressure.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_pp,
            onDismissRequest = { expanded_pp = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    peerPressure.value = i.toString()
                    expanded_pp = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("extracurricular Activities Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_ea = !expanded_ea } // Toggle dropdown on click
        ) {
            Text(
                text = "${extracurricularActivities.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_ea,
            onDismissRequest = { expanded_ea = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    extracurricularActivities.value = i.toString()
                    expanded_ea = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
        Text("bullying Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(color = Color.White)
                .clickable { expanded_b = !expanded_b } // Toggle dropdown on click
        ) {
            Text(
                text = "${bullying.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black // Set the text color to black
            )
        }

        DropdownMenu(
            expanded = expanded_b,
            onDismissRequest = { expanded_b = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            // DropdownMenuItems for the anxiety level range
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    bullying.value = i.toString()
                    expanded_b = false
                }) {
                    Text("$i", color = Color.Black) // Set the text color to black
                }
            }
        }
//        TextField(
//            value = bullying.value,
//            onValueChange = { bullying.value = it },
//            label = { Text("bullying Level") },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(8.dp)
//        )



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
            Text("${showResult.value}")
        }



    }
}