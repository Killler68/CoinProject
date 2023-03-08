package com.example.coinproject.common.activity.viewmodel

import androidx.lifecycle.ViewModel
import com.example.coinproject.listcoin.FragmentListCoin
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ActivityViewModel(
    private val router: Router,
    private val navigatorHolder: NavigatorHolder
) : ViewModel() {

    fun setNavigator(navigator: Navigator) = navigatorHolder.setNavigator(navigator)

    fun removeNavigator() = navigatorHolder.removeNavigator()

    fun toListCoin() = router.navigateTo(
        FragmentScreen {
            FragmentListCoin()
        })
}