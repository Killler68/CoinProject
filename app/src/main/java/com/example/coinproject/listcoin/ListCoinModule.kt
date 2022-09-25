package com.example.coinproject.listcoin

import androidx.lifecycle.ViewModel
import com.example.coinproject.listcoin.repository.ListCoinRepository
import com.example.coinproject.listcoin.repository.ListCoinRepositoryImpl
import com.example.coinproject.listcoin.usecase.ListCoinUseCase
import com.example.coinproject.listcoin.usecase.ListCoinUseCaseImpl
import com.example.coinproject.listcoin.viewmodel.ListCoinViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
class ListCoinModule {

    @Provides
    fun provideRepository(): ListCoinRepository = ListCoinRepositoryImpl()

    @Provides
    fun provideUseCase(repository: ListCoinRepository): ListCoinUseCase =
        ListCoinUseCaseImpl(repository)


    @Provides
    @IntoMap
    @ClassKey(ListCoinViewModel::class)
    fun getViewModelListCoin(
        useCase: ListCoinUseCase,
    ): ViewModel {
        return ListCoinViewModel(
            useCase
        )
    }
}