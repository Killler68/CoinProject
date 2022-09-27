package com.example.coinproject.informationcoin.usecase

import com.example.coinproject.informationcoin.model.InformationCoinData
import com.example.coinproject.informationcoin.repository.InformationCoinRepository
import io.reactivex.Single

class InformationCoinUseCaseImpl(
    private val repository: InformationCoinRepository
) : InformationCoinUseCase {

    private val coins = mutableMapOf<String, MutableList<InformationCoinData>>()

    override fun invoke(): Single<InformationCoinData> {
        return repository.getLoadInformationCoin().map {

            if (coins[it.id] != null)
                coins[it.id]?.add(it)
            else coins[it.id] = mutableListOf(it)

            InformationCoinData(
                it.id,
                it.name,
                it.image,
                it.description,
                it.categories
            )
        }
    }
}
