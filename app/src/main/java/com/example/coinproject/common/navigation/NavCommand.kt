package com.example.coinproject.common.navigation

import android.os.Bundle
import androidx.core.os.bundleOf

data class NavCommand(
    val action: Int,
    val command: Bundle = bundleOf()
)
