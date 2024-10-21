package com.hoavu.cryptotracker

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.hoavu.cryptotracker.core.presentation.util.ObserveAsEvent
import com.hoavu.cryptotracker.core.presentation.util.toString
import com.hoavu.cryptotracker.crypto.presentation.coin_list.CoinListEvent
import com.hoavu.cryptotracker.crypto.presentation.coin_list.CoinListScreen
import com.hoavu.cryptotracker.crypto.presentation.coin_list.CoinListViewModel
import com.hoavu.cryptotracker.ui.theme.CryptoTrackerTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val viewModel = koinViewModel<CoinListViewModel>()
                    val state by viewModel.state.collectAsState()
                    val context = LocalContext.current
                    ObserveAsEvent(events = viewModel.events) { event ->
                        when (event) {
                            is CoinListEvent.Error -> {
                                Toast.makeText(
                                    context,
                                    event.error.toString(context),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }

                    CoinListScreen(
                        state = state,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}