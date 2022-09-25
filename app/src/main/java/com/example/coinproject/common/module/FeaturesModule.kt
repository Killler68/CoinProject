package com.example.coinproject.common.module

import com.example.coinproject.common.application.ApplicationModule
import com.example.coinproject.informationcoin.InformationCoinModule
import com.example.coinproject.listcoin.ListCoinModule
import dagger.Module


@Module(
    includes = [
        ListCoinModule::class,
        InformationCoinModule::class,
        ApplicationModule::class
    ]
)
class FeaturesModule