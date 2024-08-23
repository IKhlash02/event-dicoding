package com.example.capstone1.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.capstone1.core.domain.usecase.EventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(eventUseCase: EventUseCase): ViewModel() {
val event = eventUseCase.getAllEvent().asLiveData()
}