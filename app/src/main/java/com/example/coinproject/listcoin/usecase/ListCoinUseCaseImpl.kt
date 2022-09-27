package com.example.coinproject.listcoin.usecase

import com.example.coinproject.listcoin.model.CoinData
import com.example.coinproject.listcoin.repository.ListCoinRepository
import io.reactivex.Single

class ListCoinUseCaseImpl(private val repository: ListCoinRepository) : ListCoinUseCase {

    private val coins = mutableMapOf<String, MutableList<CoinData>>()

    override operator fun invoke(): Single<List<CoinData>> {
        return repository.getLoadCoin().map {

            it.forEach {
                if (coins[it.id] != null)
                    coins[it.id]?.add(it)
                else coins[it.id] = mutableListOf(it)
            }

            coins.map {
                CoinData(
                    it.value.first().id,
                    it.value.first().symbol,
                    it.value.first().name,
                    it.value.first().image,
                    it.value.first().current_price,
                    it.value.first().market_cap_change_percentage_24h
                )
            }
        }
    }
}