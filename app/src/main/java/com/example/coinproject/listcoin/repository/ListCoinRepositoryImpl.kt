package com.example.coinproject.listcoin.repository

import com.example.coinproject.common.api.CoinApi
import com.example.coinproject.listcoin.model.CoinData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListCoinRepositoryImpl(private val coinApi: CoinApi) :
    ListCoinUsdRepository, ListCoinEurRepository {

    override suspend fun getCoinsUsd(): List<CoinData> =
        withContext(Dispatchers.IO) {
            val response = coinApi.getCoinsUsdData()
                .map {
                    CoinData(
                        it.id,
                        it.symbol,
                        it.name,
                        it.image,
                        it.current_price,
                        it.market_cap_change_percentage_24h
                    )
                }
            response
        }

    override suspend fun getCoinsEur(): List<CoinData> =
        withContext(Dispatchers.IO) {
            val response = coinApi.getCoinsEurData()
                .map {
                    CoinData(
                        it.id,
                        it.symbol,
                        it.name,
                        it.image,
                        it.current_price,
                        it.market_cap_change_percentage_24h
                    )
                }
            response
        }
}
