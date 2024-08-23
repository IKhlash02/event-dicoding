package com.example.capstone1.core.data.source.remote.network

import com.example.capstone1.core.data.source.remote.response.ListEventResponse

import retrofit2.http.*


interface ApiService {

    @GET("events")
  suspend  fun getList(
    ): ListEventResponse
}