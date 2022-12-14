package com.example.coinproject.listcoin.repository

import com.example.coinproject.common.api.CoinApi
import com.example.coinproject.listcoin.model.CoinData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListCoinRepositoryImpl(private val coinApi: CoinApi) :
    ListCoinUsdRepository, ListCoinEurRepository {

    override fun getCoinsUsd(): Single<List<CoinData>> {
        try {
            val response = coinApi.getCoinsUsdData()
            return response.map {
                it.map {
                    CoinData(
                        it.id,
                        it.symbol,
                        it.name,
                        it.image,
                        it.current_price,
                        it.market_cap_change_percentage_24h
                    )
                }
            }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        } catch (e: Exception) {
            throw Exception()
        }
    }

    override fun getCoinsEur(): Single<List<CoinData>> {
        val response = coinApi.getCoinsEurData()
        return response.map {
            it.map {
                CoinData(
                    it.id,
                    it.symbol,
                    it.name,
                    it.image,
                    it.current_price,
                    it.market_cap_change_percentage_24h
                )
            }
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
