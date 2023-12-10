package com.imtuc.stressid.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imtuc.stressid.repository.PredictRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PredictionViewModel @Inject constructor(
    private val repo: PredictRepository
): ViewModel() {

    val _prediction: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    val prediction: LiveData<String>
        get() = _prediction

    fun predict(
        anxietyLevel: Int,
        selfEsteem: Int,
        mentalHealthHistory: Int,
        depression: Int,
        headache: Int,
        bloodPressure: Int,
        sleepQuality: Int,
        breathingProblem: Int,
        noiseLevel: Int,
        livingConditions: Int,
        safety: Int,
        basicNeeds: Int,
        academicPerformance: Int,
        studyLoad: Int,
        teacherStudentRelationship: Int,
        futureCareerConcerns: Int,
        socialSupport: Int,
        peerPressure: Int,
        extracurricularActivities: Int,
        bullying: Int,
    )
            = viewModelScope.launch {
        repo.predict(anxietyLevel, selfEsteem, mentalHealthHistory, depression, headache, bloodPressure, sleepQuality, breathingProblem, noiseLevel, livingConditions, safety, basicNeeds, academicPerformance, studyLoad, teacherStudentRelationship, futureCareerConcerns, socialSupport, peerPressure, extracurricularActivities, bullying).let {
                response ->
            if (response.isSuccessful) {
                _prediction.value = response.body()?.get("result")!!.asString
                Log.d("Predicted Result", response.body().toString())
            } else {
                _prediction.value = response.message()
                Log.e("Predicted Result", response.message())
            }
        }
    }
}