//package com.example.capstone1.core.ui
//
//import android.content.Context
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//
//import com.example.capstone1.core.domain.usecase.EventUseCase
//import com.example.capstone1.detail.DetailViewModel
//import com.example.capstone1.di.AppScope
//import com.example.capstone1.favorite.FavoriteViewModel
//import com.example.capstone1.home.HomeViewModel
//import javax.inject.Inject
//
//@AppScope
//class ViewModelFactory  @Inject constructor(private val eventUseCase: EventUseCase) :
//    ViewModelProvider.NewInstanceFactory() {
//
//
//
//    @Suppress("UNCHECKED_CAST")
//    override fun <T : ViewModel> create(modelClass: Class<T>): T =
//        when {
//            modelClass.isAssignableFrom(HomeViewModel::class.java) -> {
//                HomeViewModel(eventUseCase) as T
//            }
//            modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
//                FavoriteViewModel(eventUseCase) as T
//            }
//            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
//                DetailViewModel(eventUseCase) as T
//            }
//
//            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
//        }
//}