package com.example.coinproject.listcoin.repository

import com.example.coinproject.listcoin.model.CoinData
import io.reactivex.Single

interface ListCoinRepository {

    fun getCoin(): Single<List<CoinData>>
    fun getLoadCoin(): Single<List<CoinData>>

}