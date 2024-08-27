package com.example.core.data

import android.util.Log
import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.domain.model.Event
import com.example.core.domain.repository.IEventRepository
import com.example.core.utils.AppExecutors
import com.example.core.utils.DataMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EventRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors,
    private val remoteDataSource: RemoteDataSource
) : IEventRepository {


    override fun getAllEvent(): Flow<Resource<List<Event>>> = flow {
        emit(Resource.Loading())
        Log.d("hasil", "haha")
        try {
            val listEvents = remoteDataSource.getAllEvent()
            Log.d("hasil succes", "$listEvents")

            if (listEvents.isNotEmpty()) {
                val mappedData = DataMapper.mapResponsesToDomain(listEvents)
                emit(Resource.Success(mappedData))
            } else {
                emit(Resource.Success(emptyList()))
            }
        } catch (e: Exception) {
            Log.d("hasil error", "$e")
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun getFavoriteEvent(): Flow<Resource<List<Event>>> = flow {
        emit(Resource.Loading())
        try {
            localDataSource.getAllEvent().collect {
                val mappedEvents = DataMapper.mapEntityToDomain(it)
                emit(Resource.Success(mappedEvents))
            }
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)

    override fun insertFavoriteEvent(event: Event) {
        val eventEntity = DataMapper.mapDomainToEntity(event)
        appExecutors.diskIO().execute { localDataSource.insertEvent(eventEntity) }
    }

    override fun deleteFavoriteEvent(event: Event) {
        val eventEntity = DataMapper.mapDomainToEntity(event)
        appExecutors.diskIO().execute { localDataSource.deleteEvent(eventEntity) }
    }

    override fun getFavoriteEventByid(id: Int): Flow<Boolean> = flow {
        try {
            val event = localDataSource.getFavoriteEventByid(id)
            emit(event != null)
        } catch (e: Exception) {
            Log.e("Database Error", "Error fetching event", e)
            emit(false)
        }
    }.flowOn(Dispatchers.IO)
}