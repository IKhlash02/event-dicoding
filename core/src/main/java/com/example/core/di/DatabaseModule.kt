package com.example.core.di

import android.content.Context
import androidx.room.Room
import com.example.core.data.source.local.room.EventDao
import com.example.core.data.source.local.room.EventDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): EventDatabase = Room.databaseBuilder(
        context,
        EventDatabase::class.java,
        "Event.db"
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideEventDao(database: EventDatabase): EventDao = database.eventDao()
}