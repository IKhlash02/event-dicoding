package com.example.capstone1.core.di

import com.example.capstone1.core.data.EventRepository
import com.example.capstone1.core.domain.repository.IEventRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(eventRepository: EventRepository): IEventRepository
}