package com.example.coinproject.common.api

import com.example.coinproject.informationcoin.model.CoinDetailResponse
import com.example.coinproject.listcoin.model.CoinResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


const val BASE_URL = "https://api.coingecko.com"
const val API_KEY_LIST_COIN = "/api/v3/coins/markets?vs_currency=usd&per_page=20"
const val API_KEY_INFORMATION_COIN = "/api/v3/coins/bitcoin"

interface CoinApi {

    @GET(API_KEY_LIST_COIN)
    fun getCoinData(): Single<List<CoinResponse>>

    @GET(API_KEY_INFORMATION_COIN)
    fun getInformationCoinData(): Single<CoinDetailResponse>

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