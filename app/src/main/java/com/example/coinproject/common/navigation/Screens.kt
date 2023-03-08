package com.example.coinproject.common.navigation

import com.example.coinproject.listcoin.FragmentListCoin
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun toListCoin() = FragmentScreen { FragmentListCoin() }
}