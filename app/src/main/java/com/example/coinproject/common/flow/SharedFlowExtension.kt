package com.example.coinproject.common.flow

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

fun <T> createSharedFlow() =
    MutableSharedFlow<T>(0, 1, BufferOverflow.DROP_LATEST)