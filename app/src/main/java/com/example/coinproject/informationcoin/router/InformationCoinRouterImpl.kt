package com.example.coinproject.informationcoin.router

import com.example.coinproject.R
import com.example.coinproject.common.navigation.NavCommand
import com.example.coinproject.informationcoin.usecase.InformationCoinRouter

class InformationCoinRouterImpl : InformationCoinRouter {

    override fun toListCoin(): NavCommand =
        NavCommand(R.id.action_fragmentInformationCoin_to_fragmentListCoin)
}