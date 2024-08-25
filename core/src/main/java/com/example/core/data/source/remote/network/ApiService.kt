package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.ListEventResponse

import retrofit2.http.*


interface ApiService {

    @GET("events")
  suspend  fun getList(
    ): ListEventResponse
}