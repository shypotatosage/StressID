package com.imtuc.stressid.viewmodel

import androidx.lifecycle.ViewModel
import com.imtuc.stressid.repository.PredictRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PredictionViewModel @Inject constructor(
    private val repo: PredictRepository
): ViewModel() {
}