package com.example.capstone1.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

import com.example.capstone1.core.data.source.local.entity.EventEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Query("SELECT * FROM event")
    fun getAllEvent(): Flow<List<EventEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun insertEvent(event: EventEntity)

    @Delete
    fun deleteEvent(event: EventEntity)

    @Query("SELECT * FROM event WHERE id = :id")
    suspend fun getFavoriteEventByid(id: Int): EventEntity?
}