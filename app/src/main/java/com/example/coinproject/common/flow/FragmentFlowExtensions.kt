package com.example.coinproject.common.flow

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*

inline fun Fragment.launchOnLifecycle(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = lifecycleScope.launch {
    CoroutineScopeWrapper(this).block()
}

inline fun Fragment.launchWhenCreated(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = lifecycleScope.launchWhenCreated {
    CoroutineScopeWrapper(this).block()
}

inline fun Fragment.launchWhenStarted(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = lifecycleScope.launchWhenStarted {
    CoroutineScopeWrapper(this).block()
}

inline fun Fragment.launchWhenResumed(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = lifecycleScope.launchWhenResumed {
    CoroutineScopeWrapper(this).block()
}

inline fun Fragment.launchOnViewLifecycle(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = viewLifecycleOwner.lifecycleScope.launch {
    CoroutineScopeWrapper(this).block()
}

inline fun Fragment.launchWhenViewCreated(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = viewLifecycleOwner.lifecycleScope.launchWhenCreated {
    CoroutineScopeWrapper(this).block()
}

inline fun Fragment.launchWhenViewStarted(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = viewLifecycleOwner.lifecycleScope.launchWhenStarted {
    CoroutineScopeWrapper(this).block()
}

inline fun AppCompatActivity.launchWhenViewStarted(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = lifecycleScope.launchWhenStarted {
    CoroutineScopeWrapper(this).block()
}

inline fun Fragment.launchWhenViewResumed(
    crossinline block: suspend CoroutineScopeWrapper.() -> Unit
) = viewLifecycleOwner.lifecycleScope.launchWhenResumed {
    CoroutineScopeWrapper(this).block()
}

class CoroutineScopeWrapper(
    val scope: CoroutineScope,
    var errorHandler: (Throwable) -> Unit = globalErrorHandler
) {
    fun <T> Flow<T>.observe(action: suspend (T) -> Unit) = this
        .onEach(action)
        .catch { errorHandler(it) }
        .launchIn(scope)

    companion object {
        var globalErrorHandler: (Throwable) -> Unit = { throw it }
    }
}