package com.example.coinproject.listcoin

import androidx.lifecycle.ViewModel
import com.example.coinproject.common.api.CoinApi
import com.example.coinproject.common.network.NetworkModule
import com.example.coinproject.listcoin.repository.ListCoinEurRepository
import com.example.coinproject.listcoin.repository.ListCoinRepositoryImpl
import com.example.coinproject.listcoin.repository.ListCoinUsdRepository
import com.example.coinproject.listcoin.usecase.ListCoinEurUseCase
import com.example.coinproject.listcoin.usecase.ListCoinEurUseCaseImpl
import com.example.coinproject.listcoin.usecase.ListCoinUsdUseCase
import com.example.coinproject.listcoin.usecase.ListCoinUsdUseCaseImpl
import com.example.coinproject.listcoin.viewmodel.ListCoinViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(includes = [NetworkModule::class])
class ListCoinModule {

    @Provides
    fun provideRepositoryUsd(coinApi: CoinApi): ListCoinUsdRepository =
        ListCoinRepositoryImpl(coinApi)

    @Provides
    fun provideRepositoryEur(coinApi: CoinApi): ListCoinEurRepository =
        ListCoinRepositoryImpl(coinApi)

    @Provides
    fun provideUseCaseUsd(repositoryUsd: ListCoinUsdRepository): ListCoinUsdUseCase =
        ListCoinUsdUseCaseImpl(repositoryUsd)

    @Provides
    fun provideUseCaseEur(repositoryEur: ListCoinEurRepository): ListCoinEurUseCase =
        ListCoinEurUseCaseImpl(repositoryEur)

    @Provides
    @IntoMap
    @ClassKey(ListCoinViewModel::class)
    fun getViewModelListCoin(getCoinsUsd: ListCoinUsdUseCase, getCoinsEur: ListCoinEurUseCase)
            : ViewModel {
        return ListCoinViewModel(getCoinsUsd, getCoinsEur)
    }
}