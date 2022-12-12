package com.example.coinproject.listcoin.usecase

import com.example.coinproject.common.navigation.NavCommand
import com.example.coinproject.listcoin.viewmodel.ListCoinInformationNavigatorUseCase

class ListCoinInformationNavigatorUseCaseImpl(
    private val router: ListCoinRouter
) : ListCoinInformationNavigatorUseCase {

    override fun invoke(id: String): NavCommand = router.toInformationCoin(id)
}