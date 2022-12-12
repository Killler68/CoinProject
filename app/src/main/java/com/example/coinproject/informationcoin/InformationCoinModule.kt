package com.example.coinproject.informationcoin

import androidx.lifecycle.ViewModel
import com.example.coinproject.common.api.CoinApi
import com.example.coinproject.common.network.NetworkModule
import com.example.coinproject.informationcoin.repository.InformationCoinRepository
import com.example.coinproject.informationcoin.repository.InformationCoinRepositoryImpl
import com.example.coinproject.informationcoin.router.InformationCoinRouterImpl
import com.example.coinproject.informationcoin.usecase.InformationCoinListNavigatorUseCaseImpl
import com.example.coinproject.informationcoin.usecase.InformationCoinRouter
import com.example.coinproject.informationcoin.usecase.InformationCoinUseCase
import com.example.coinproject.informationcoin.usecase.InformationCoinUseCaseImpl
import com.example.coinproject.informationcoin.viewmodel.InformationCoinListNavigatorUseCase
import com.example.coinproject.informationcoin.viewmodel.InformationCoinViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(includes = [NetworkModule::class])
class InformationCoinModule {

    @Provides
    fun provideInformationCoinRouter(): InformationCoinRouter = InformationCoinRouterImpl()

    @Provides
    fun provideInformationCoinListNavigatorUseCase(router: InformationCoinRouter):
            InformationCoinListNavigatorUseCase = InformationCoinListNavigatorUseCaseImpl(router)

    @Provides
    fun provideInformationCoinRepository(api: CoinApi): InformationCoinRepository =
        InformationCoinRepositoryImpl(api)

    @Provides
    fun provideInformationCoinUseCase(repository: InformationCoinRepository): InformationCoinUseCase =
        InformationCoinUseCaseImpl(repository)

    @Provides
    @IntoMap
    @ClassKey(InformationCoinViewModel::class)
    fun getViewModelInformationCoin(
        getInformationCoin: InformationCoinUseCase,
        navigateToListCoinUseCase: InformationCoinListNavigatorUseCase
    ): ViewModel {
        return InformationCoinViewModel(
            getInformationCoin,
            navigateToListCoinUseCase
        )
    }
}