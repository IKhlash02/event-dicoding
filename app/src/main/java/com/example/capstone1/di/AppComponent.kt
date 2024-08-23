//package com.example.capstone1.di
//
//import com.example.capstone1.core.di.CoreComponent
//import com.example.capstone1.detail.DetailActivity
//import com.example.capstone1.favorite.FavoriteActivity
//import com.example.capstone1.home.MainActivity
//import dagger.Component
//
//@AppScope
//@Component(
//    dependencies = [CoreComponent::class],
//    modules = [AppModule::class]
//)
//interface AppComponent {
//    @Component.Factory
//    interface Factory {
//        fun create(coreComponent: CoreComponent): AppComponent
//    }
//
//    fun inject(activity: MainActivity)
//    fun inject(activity: DetailActivity)
//    fun inject(activity: FavoriteActivity)
//}