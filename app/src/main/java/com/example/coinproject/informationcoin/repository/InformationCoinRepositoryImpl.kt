package com.example.coinproject.informationcoin.repository

import com.example.coinproject.common.api.CoinApi
import com.example.coinproject.informationcoin.model.InformationCoinData
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InformationCoinRepositoryImpl(private val coinApi: CoinApi) : InformationCoinRepository {

    override fun getInformationCoin(id: String?): Single<InformationCoinData> {
        val response = coinApi.getInformationCoinData(id)
        return response.map {
            InformationCoinData(
                it.id,
                it.name,
                it.image.large,
                it.description.en,
                it.categories.toString()
            )
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}


