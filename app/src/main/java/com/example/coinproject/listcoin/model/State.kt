package com.example.coinproject.listcoin.model

sealed class State {
    object Loading : State()
    object Loaded : State()
    object Error : State()
}

