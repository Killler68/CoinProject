package com.example.coinproject.common.api

import com.example.coinproject.informationcoin.model.CoinDetailResponse
import com.example.coinproject.listcoin.model.CoinResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


const val BASE_URL = "https://api.coingecko.com"

interface CoinApi {

    @GET("/api/v3/coins/markets?vs_currency=usd&per_page=25")
    fun getCoinsUsdData(): Single<List<CoinResponse>>

    @GET("/api/v3/coins/markets?vs_currency=eur&per_page=25")
    fun getCoinsEurData(): Single<List<CoinResponse>>

    @GET("/api/v3/coins/{id}")
    fun getInformationCoinData(@Path("id") id: String?): Single<CoinDetailResponse>

    companion object {
        fun create(): CoinApi {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(CoinApi::class.java)
        }
    }
}