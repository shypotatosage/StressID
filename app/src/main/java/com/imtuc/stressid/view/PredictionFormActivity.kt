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
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material.ButtonDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.imtuc.stressid.navigation.Screen
import com.imtuc.stressid.ui.theme.GrayBorder
import com.imtuc.stressid.ui.theme.Purple40


@Composable
fun PredictionFormActivity(
    predictionViewModel: PredictionViewModel,
    lifecycleOwner: LifecycleOwner,
    navController: NavHostController
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

    var expanded_blood by remember {
        mutableStateOf(false)
    }

    predictionViewModel.prediction.observe(lifecycleOwner, Observer {
            response ->
        if (response != null) {
            showResult.value = predictionViewModel.prediction.value.toString()

            navController.popBackStack()
            navController.navigate(
                Screen.Result.passParam(
                    showResult.value
                )
            )

            predictionViewModel.resetPrediction()
        }
    })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Let's Predict Your Condition!",
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold
            )
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text("Try to input your condition based on the questions below. Select the levels according to your current condition.")
        Spacer(modifier = Modifier.height(24.dp))
        Text("Anxiety Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded = !expanded }
        ) {
            Text(
                text = if (anxietyLevel.value.isEmpty()) "Select Anxiety Level" else "${anxietyLevel.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..21) {
                DropdownMenuItem(onClick = {
                    anxietyLevel.value = i.toString()
                    expanded = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }

        Text("Self Esteem Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_sE = !expanded_sE }
        ) {
            Text(
                text = if (selfEsteem.value.isEmpty()) "Select Self Esteem Level" else "${selfEsteem.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..30) {
                DropdownMenuItem(onClick = {
                    selfEsteem.value = i.toString()
                    expanded_sE = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }

        var mentalHealthOptions = listOf(
            "Yes",
            "No",
       )

        Text("Mental Health History:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_mH = !expanded_mH }
        ) {
            Text(
                text = if (mentalHealthHistory.value.isEmpty()) "Select Mental Health Problems" else "${mentalHealthOptions[mentalHealthHistory.value.toInt()]}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
           for ((index, option) in mentalHealthOptions.withIndex()) {
                DropdownMenuItem(onClick = {
                    mentalHealthHistory.value = index.toString()
                    expanded_mH = false
                }) {
                    Text(option, color = Color.Black)
                }
            }
        }

        Text("Depression Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_d = !expanded_d }
        ) {
            Text(
                text = if (depression.value.isEmpty()) "Select Depression Level" else "${depression.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..27) {
                DropdownMenuItem(onClick = {
                    depression.value = i.toString()
                    expanded_d = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }


        Text("Headache Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_h = !expanded_h }
        ) {
            Text(
                text = if (headache.value.isEmpty()) "Select Headache Level" else "${headache.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    headache.value = i.toString()
                    expanded_h = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }

        var bloodPressureOptions = listOf(
            "<100 / <70",
            "<120 / <80",
            "<130 / <80",
            "<140 / <90",
            ">140 / >90",
            ">180 / >120"
        )

        Text("Blood Pressure Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_blood = !expanded_blood }
        ) {
            Text(
                text = if (bloodPressure.value.isEmpty()) "Select Blood Pressure Level" else "${bloodPressureOptions[bloodPressure.value.toInt()]}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
            )
        }

        DropdownMenu(
            expanded = expanded_blood,
            onDismissRequest = { expanded_blood = false },
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth(0.875f)
                .align(alignment = Alignment.CenterHorizontally)
        ) {
            for ((index, option) in bloodPressureOptions.withIndex()) {
                DropdownMenuItem(onClick = {
                    bloodPressure.value = index.toString()
                    expanded_blood = false
                }) {
                    Text(option, color = Color.Black)
                }
            }
        }

        Text("Sleep Quality Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_sq = !expanded_sq }
        ) {
            Text(
                text = if (sleepQuality.value.isEmpty()) "Select Sleep Quality Level" else "${sleepQuality.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    sleepQuality.value = i.toString()
                    expanded_sq = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }

        Text("Breathing Problem Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_bp = !expanded_bp }
        ) {
            Text(
                text = if (breathingProblem.value.isEmpty()) "Select Breathing Problem Level" else "${breathingProblem.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    breathingProblem.value = i.toString()
                    expanded_bp = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }

        Text("Noise Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_nl = !expanded_nl }
        ) {
            Text(
                text = if (noiseLevel.value.isEmpty()) "Select Noise Level" else "${noiseLevel.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    noiseLevel.value = i.toString()
                    expanded_nl = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }

        Text("Living Conditions Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_lc = !expanded_lc }
        ) {
            Text(
                text = if (livingConditions.value.isEmpty()) "Select Living Conditions Level" else "${livingConditions.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    livingConditions.value = i.toString()
                    expanded_lc = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Safety Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_s = !expanded_s }
        ) {
            Text(
                text = if (safety.value.isEmpty()) "Select Safety Level" else "${safety.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    safety.value = i.toString()
                    expanded_s = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Basic Needs Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_bn = !expanded_bn }
        ) {
            Text(
                text = if (basicNeeds.value.isEmpty()) "Select Basic Needs Level" else "${basicNeeds.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    basicNeeds.value = i.toString()
                    expanded_bn = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Academic Performances Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_ap = !expanded_ap }
        ) {
            Text(
                text = if (academicPerformance.value.isEmpty()) "Select Academic Performance Level" else "${academicPerformance.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    academicPerformance.value = i.toString()
                    expanded_ap = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Study Load Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_sl = !expanded_sl }
        ) {
            Text(
                text = if (studyLoad.value.isEmpty()) "Select Study Load Level" else "${studyLoad.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    studyLoad.value = i.toString()
                    expanded_sl = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Teacher Student Relationship Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_tsr = !expanded_tsr }
        ) {
            Text(
                text = if (teacherStudentRelationship.value.isEmpty()) "Select Teacher Student Relationship Level" else "${teacherStudentRelationship.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    teacherStudentRelationship.value = i.toString()
                    expanded_tsr = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Future Career Concerns Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_fcc = !expanded_fcc }
        ) {
            Text(
                text = if (futureCareerConcerns.value.isEmpty()) "Select Future Career Concerns Level" else "${futureCareerConcerns.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    futureCareerConcerns.value = i.toString()
                    expanded_fcc = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Social Support Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_ss = !expanded_ss }
        ) {
            Text(
                text = if (socialSupport.value.isEmpty()) "Select Social Support Level" else "${socialSupport.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    socialSupport.value = i.toString()
                    expanded_ss = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Peer Pressure Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_pp = !expanded_pp }
        ) {
            Text(
                text = if (peerPressure.value.isEmpty()) "Select Peer Pressure Level" else "${peerPressure.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    peerPressure.value = i.toString()
                    expanded_pp = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Extracurricular Activities Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_ea = !expanded_ea }
        ) {
            Text(
                text = if (extracurricularActivities.value.isEmpty()) "Select Extracurricular Activities Level" else "${extracurricularActivities.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    extracurricularActivities.value = i.toString()
                    expanded_ea = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
        Text("Bullying Level:")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp)
                .background(color = Color.White)
                .border(
                    BorderStroke(
                        width = 0.85.dp,
                        color = GrayBorder
                    ),
                    shape = RoundedCornerShape(8.dp)
                )
                .clickable { expanded_b = !expanded_b }
        ) {
            Text(
                text = if (bullying.value.isEmpty()) "Select Bullying Level" else "${bullying.value}",
                modifier = Modifier.padding(8.dp),
                color = Color.Black
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
            for (i in 0..5) {
                DropdownMenuItem(onClick = {
                    bullying.value = i.toString()
                    expanded_b = false
                }) {
                    Text("$i", color = Color.Black)
                }
            }
        }
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
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Purple40, contentColor = Color.Black),
        ) {
            Text(
                "Check",
                style = TextStyle(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    color = Color.White
                )
            )
        }

//        if (result.value) {
//            val resultText = when (showResult.value) {
//                "0" -> "You're good!"
//                "1" -> "Stress has started to build up, make sure to take a rest"
//                "2" -> "You're not in good condition, seek help immediately!"
//                else -> "Unknown result"
//            }
//            Text(resultText)
//        }

    }
}