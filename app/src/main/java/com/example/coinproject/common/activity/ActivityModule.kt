package com.example.coinproject.common.activity

import androidx.lifecycle.ViewModel
import com.example.coinproject.common.activity.viewmodel.ActivityViewModel
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
class ActivityModule {

    @Provides
    @IntoMap
    @ClassKey(ActivityViewModel::class)
    fun provideActivityViewModel(
        router: Router,
        navigatorHolder: NavigatorHolder
    ): ViewModel = ActivityViewModel(
        router,
        navigatorHolder
    )
}