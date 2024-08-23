package com.example.capstone1.core.data.source.remote

import com.example.capstone1.core.data.source.remote.network.ApiService
import com.example.capstone1.core.data.source.remote.response.EventResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService){

    suspend fun getAllEvent():List<EventResponse> =   apiService.getList().listEvents
}