package com.example.coinproject.listcoin.repository

import com.example.coinproject.listcoin.model.CoinData
import io.reactivex.Single

interface ListCoinEurRepository {

    suspend fun getCoinsEur(): List<CoinData>

}