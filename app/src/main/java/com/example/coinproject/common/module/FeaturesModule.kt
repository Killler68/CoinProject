package com.example.coinproject.common.module

import com.example.coinproject.common.activity.ActivityModule
import com.example.coinproject.common.application.ApplicationModule
import com.example.coinproject.common.navigation.NavigationModule
import com.example.coinproject.informationcoin.InformationCoinModule
import com.example.coinproject.listcoin.ListCoinModule
import dagger.Module


@Module(
    includes = [
        ListCoinModule::class,
        InformationCoinModule::class,
        ApplicationModule::class,
        ActivityModule::class,
        NavigationModule::class
    ]
)
class FeaturesModule