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
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Singleton

@Module
class ListCoinModule {

    @Provides
    fun provideRepository(): ListCoinRepository = ListCoinRepositoryImpl()

    @Provides
    fun provideUseCase(repository: ListCoinRepository): ListCoinUseCase =
        ListCoinUseCaseImpl(repository)

    @Provides
    @Singleton
    fun coinEventBus(): BehaviorSubject<String> = BehaviorSubject.create()

    @Provides
    @IntoMap
    @ClassKey(ListCoinViewModel::class)
    fun getViewModelListCoin(
        useCase: ListCoinUseCase,
        coinEventBus: BehaviorSubject<String>
    ): ViewModel {
        return ListCoinViewModel(
            useCase,
            coinEventBus
        )
    }
}