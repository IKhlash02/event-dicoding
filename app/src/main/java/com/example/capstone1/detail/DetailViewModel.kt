package com.example.capstone1.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.capstone1.core.data.Resource
import com.example.capstone1.core.domain.model.Event
import com.example.capstone1.core.domain.usecase.EventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject  constructor(private val eventUseCase: EventUseCase): ViewModel() {

    fun insert(event: Event){
        eventUseCase.insertFavoriteEvent(event)
    }

    fun delete(event: Event){
        eventUseCase.deleteFavoriteEvent(event)
    }

    fun getFavoriteEventById(id: Int): LiveData<Boolean> = eventUseCase.getFavoriteEventByid(id).asLiveData()
}