package com.example.coinproject.listcoin.repository

import com.example.coinproject.listcoin.model.CoinData
import io.reactivex.Single

interface ListCoinUsdRepository {

    fun getCoinsUsd(): Single<List<CoinData>>

}