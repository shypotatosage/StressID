package com.imtuc.stressid.retrofit

import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPointAPI {

    @GET("/predict/{anxiety_level}/{self_esteem}/{mental_health_history}/{depression}/{headache}/{blood_pressure}/{sleep_quality}/{breathing_problem}/{noise_level}/{living_conditions}/{safety}/{basic_needs}/{academic_performance}/{study_load}/{teacher_student_relationship}/{future_career_concerns}/{social_support}/{peer_pressure}/{extracurricular_activities}/{bullying}")
    suspend fun predict(
        @Path("anxiety_level") anxietyLevel: Int,
        @Path("self_esteem") selfEsteem: Int,
        @Path("mental_health_history") mentalHealthHistory: Int,
        @Path("depression") depression: Int,
        @Path("headache") headache: Int,
        @Path("blood_pressure") bloodPressure: Int,
        @Path("sleep_quality") sleepQuality: Int,
        @Path("breathing_problem") breathingProblem: Int,
        @Path("noise_level") noiseLevel: Int,
        @Path("living_conditions") livingConditions: Int,
        @Path("safety") safety: Int,
        @Path("basic_needs") basicNeeds: Int,
        @Path("academic_performance") academicPerformance: Int,
        @Path("study_load") studyLoad: Int,
        @Path("teacher_student_relationship") teacherStudentRelationship: Int,
        @Path("future_career_concerns") futureCareerConcerns: Int,
        @Path("social_support") socialSupport: Int,
        @Path("peer_pressure") peerPressure: Int,
        @Path("extracurricular_activities") extracurricularActivities: Int,
        @Path("bullying") bullying: Int,
    ): Response<JsonObject>

}