package com.example.coinproject.common.application

import androidx.lifecycle.ViewModelProvider
import com.example.coinproject.common.module.FeaturesModule
import com.example.coinproject.common.viewmodel.ViewModelModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        FeaturesModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun getViewModelFactory(): ViewModelProvider.Factory
}