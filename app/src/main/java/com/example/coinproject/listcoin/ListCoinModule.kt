package com.example.coinproject.listcoin

import androidx.lifecycle.ViewModel
import com.example.coinproject.common.api.BASE_URL
import com.example.coinproject.common.api.CoinApi
import com.example.coinproject.common.network.NetworkModule
import com.example.coinproject.listcoin.repository.ListCoinRepository
import com.example.coinproject.listcoin.repository.ListCoinRepositoryImpl
import com.example.coinproject.listcoin.usecase.ListCoinUseCase
import com.example.coinproject.listcoin.usecase.ListCoinUseCaseImpl
import com.example.coinproject.listcoin.viewmodel.ListCoinViewModel
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [NetworkModule::class])
class ListCoinModule {

    @Provides
    fun provideApi(retrofit: Retrofit): CoinApi = retrofit.create(CoinApi::class.java)

    @Provides
    fun provideRepository(coinApi: CoinApi): ListCoinRepository = ListCoinRepositoryImpl(coinApi)

    @Provides
    fun provideRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .build()
    }

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