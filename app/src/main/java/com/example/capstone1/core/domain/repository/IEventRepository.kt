package com.example.capstone1.core.domain.repository

import com.example.capstone1.core.data.Resource

import com.example.capstone1.core.domain.model.Event
import kotlinx.coroutines.flow.Flow


interface IEventRepository {

    fun getAllEvent(): Flow<Resource<List<Event>>>

    fun getFavoriteEvent(): Flow<Resource<List<Event>>>

    fun  insertFavoriteEvent(event: Event)
    fun  deleteFavoriteEvent(event: Event)

     fun getFavoriteEventByid(id: Int): Flow<Boolean>
}