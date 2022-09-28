package com.example.coinproject.listcoin.repository

import com.example.coinproject.listcoin.model.CoinData
import io.reactivex.Single

interface ListCoinRepository {

    fun getCoinsUsd(): Single<List<CoinData>>

    fun getCoinsEur(): Single<List<CoinData>>

}