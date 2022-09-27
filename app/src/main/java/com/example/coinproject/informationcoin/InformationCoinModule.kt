package com.example.coinproject.informationcoin

import androidx.lifecycle.ViewModel
import com.example.coinproject.common.api.CoinApi
import com.example.coinproject.common.network.NetworkModule
import com.example.coinproject.informationcoin.repository.InformationCoinRepository
import com.example.coinproject.informationcoin.repository.InformationCoinRepositoryImpl
import com.example.coinproject.informationcoin.usecase.InformationCoinUseCase
import com.example.coinproject.informationcoin.usecase.InformationCoinUseCaseImpl
import com.example.coinproject.informationcoin.viewmodel.InformationCoinViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(includes = [NetworkModule::class])
class InformationCoinModule {

    @Provides
    fun provideARepository(api: CoinApi): InformationCoinRepository =
        InformationCoinRepositoryImpl(api)

    @Provides
    fun provideAUseCase(repository: InformationCoinRepository): InformationCoinUseCase =
        InformationCoinUseCaseImpl(repository)

    @Provides
    @IntoMap
    @ClassKey(InformationCoinViewModel::class)
    fun getViewModelInformationCoin(
        useCase: InformationCoinUseCase
    ): ViewModel {
        return InformationCoinViewModel(useCase)
    }
}