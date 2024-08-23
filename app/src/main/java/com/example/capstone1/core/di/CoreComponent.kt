//package com.example.capstone1.core.di
//
//import android.content.Context
//import com.example.capstone1.core.domain.repository.IEventRepository
//import dagger.BindsInstance
//import dagger.Component
//import javax.inject.Singleton
//
//@Singleton
//@Component(
//    modules = [RepositoryModule::class]
//)
//interface CoreComponent {
//
//    @Component.Factory
//    interface Factory {
//        fun create(@BindsInstance context: Context): CoreComponent
//    }
//
//    fun provideRepository() : IEventRepository
//}