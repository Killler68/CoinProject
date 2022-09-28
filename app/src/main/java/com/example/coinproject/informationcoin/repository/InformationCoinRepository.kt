package com.example.coinproject.informationcoin.repository

import com.example.coinproject.informationcoin.model.InformationCoinData
import io.reactivex.Single

interface InformationCoinRepository {

    fun getInformationCoin(id: String): Single<InformationCoinData>

}