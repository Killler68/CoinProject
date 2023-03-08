package com.example.coinproject.informationcoin.repository

import com.example.coinproject.common.api.CoinApi
import com.example.coinproject.informationcoin.model.InformationCoinData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InformationCoinRepositoryImpl(private val coinApi: CoinApi) : InformationCoinRepository {

    override suspend fun getInformationCoin(id: String?) =
        withContext(Dispatchers.IO) {
            val infoCoinResponse = coinApi.getInformationCoinData(id)
            InformationCoinData(
                infoCoinResponse.id,
                infoCoinResponse.name,
                infoCoinResponse.image.large,
                infoCoinResponse.description.en,
                infoCoinResponse.categories.toString()
            )
        }
}


