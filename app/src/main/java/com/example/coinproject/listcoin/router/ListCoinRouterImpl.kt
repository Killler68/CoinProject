package com.example.coinproject.listcoin.router

import androidx.core.os.bundleOf
import com.example.coinproject.R
import com.example.coinproject.common.navigation.NavCommand
import com.example.coinproject.informationcoin.coinIdKey
import com.example.coinproject.listcoin.usecase.ListCoinRouter

class ListCoinRouterImpl : ListCoinRouter {

    override fun toInformationCoin(id: String): NavCommand =
        NavCommand(
            R.id.action_fragmentListCoin_to_fragmentInformationCoin,
            bundleOf(coinIdKey to id)
        )
}