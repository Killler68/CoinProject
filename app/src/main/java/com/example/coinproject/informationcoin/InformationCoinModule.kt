package com.example.coinproject.informationcoin

import androidx.lifecycle.ViewModel
import com.example.coinproject.common.api.CoinApi
import com.example.coinproject.common.network.NetworkModule
import com.example.coinproject.informationcoin.repository.InformationCoinRepository
import com.example.coinproject.informationcoin.repository.InformationCoinRepositoryImpl
import com.example.coinproject.informationcoin.usecase.BackNavigatorUseCaseImpl
import com.example.coinproject.informationcoin.usecase.InformationCoinUseCase
import com.example.coinproject.informationcoin.usecase.InformationCoinUseCaseImpl
import com.example.coinproject.informationcoin.viewmodel.BackNavigatorUseCase
import com.example.coinproject.informationcoin.viewmodel.InformationCoinViewModel
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module(includes = [NetworkModule::class])
class InformationCoinModule {


    @Provides
    fun provideInformationCoinRepository(api: CoinApi): InformationCoinRepository =
        InformationCoinRepositoryImpl(api)

    @Provides
    fun provideInformationCoinUseCase(repository: InformationCoinRepository): InformationCoinUseCase =
        InformationCoinUseCaseImpl(repository)

    @Provides
    fun provideBackNavigatorUseCase(router: Router): BackNavigatorUseCase =
        BackNavigatorUseCaseImpl(router)

    @Provides
    @IntoMap
    @ClassKey(InformationCoinViewModel::class)
    fun getViewModelInformationCoin(
        getInformationCoin: InformationCoinUseCase,
        navigateToListCoinUseCase: BackNavigatorUseCase
    ): ViewModel {
        return InformationCoinViewModel(
            getInformationCoin,
            navigateToListCoinUseCase
        )
    }
}