package com.hoavu.cryptotracker.crypto.presentation.coin_list

import com.hoavu.cryptotracker.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError) : CoinListEvent
}