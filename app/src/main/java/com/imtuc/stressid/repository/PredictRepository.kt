package com.imtuc.stressid.repository

import com.imtuc.stressid.retrofit.EndPointAPI
import javax.inject.Inject

class PredictRepository @Inject constructor(
    private val api: EndPointAPI
) {

    suspend fun predict(
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
    ) = api.predict(anxietyLevel, selfEsteem, mentalHealthHistory, depression, headache, bloodPressure, sleepQuality, breathingProblem, noiseLevel, livingConditions, safety, basicNeeds, academicPerformance, studyLoad, teacherStudentRelationship, futureCareerConcerns, socialSupport, peerPressure, extracurricularActivities, bullying)

}