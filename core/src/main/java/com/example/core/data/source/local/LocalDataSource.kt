package com.example.core.data.source.local


import com.example.core.data.source.local.entity.EventEntity
import com.example.core.data.source.local.room.EventDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val eventDao: EventDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(eventDao: EventDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(eventDao)
            }
    }

    fun getAllEvent(): Flow<List<EventEntity>> = eventDao.getAllEvent()

    fun insertEvent(event: EventEntity) = eventDao.insertEvent(event)

    fun deleteEvent(event: EventEntity) = eventDao.deleteEvent(event)

    suspend fun getFavoriteEventByid(id: Int): EventEntity? = eventDao.getFavoriteEventByid(id)
}