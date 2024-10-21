package com.hoavu.cryptotracker.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.hoavu.cryptotracker.crypto.presentation.models.CoinUI

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUI> = emptyList(),
    val selectedCoin: CoinUI? = null,

)
