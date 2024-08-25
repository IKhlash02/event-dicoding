package com.example.capstone1.di

import com.example.core.domain.usecase.EventInteractor
import com.example.core.domain.usecase.EventUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideEventUseCase(eventInteractor: EventInteractor): EventUseCase

}