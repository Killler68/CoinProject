package com.example.coinproject.informationcoin.repository

import com.example.coinproject.informationcoin.model.InformationCoinData
import io.reactivex.Single

interface InformationCoinRepository {

    fun getInformationCoin(): Single<InformationCoinData>
    fun getLoadInformationCoin(): Single<InformationCoinData>
}