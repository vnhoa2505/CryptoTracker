package com.hoavu.cryptotracker.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hoavu.cryptotracker.crypto.presentation.models.DisplayableNumber
import com.hoavu.cryptotracker.ui.theme.CryptoTrackerTheme

@Composable
fun PriceChange(
    change: DisplayableNumber,
    modifier: Modifier = Modifier
) {
    val contentColor = if (change.value < 0.0) {
        MaterialTheme.colorScheme.onErrorContainer
    } else Color.Green

    val backgroundColor = if (change.value < 0.0) {
        MaterialTheme.colorScheme.errorContainer.copy(0.8f)
    } else Color.Green.copy(alpha = 0.5f)

    val iconVector = if (change.value < 0.0) {
        Icons.Default.KeyboardArrowDown
    } else Icons.Default.KeyboardArrowUp

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100f))
            .background(backgroundColor)
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = iconVector,
            contentDescription = null,
            modifier = Modifier.size(20.dp),
            tint = contentColor
        )
        Text(
            text = "${change.formatted} %",
            color = contentColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
        )
    }
}

@Preview
@PreviewLightDark
@Composable
private fun PriceChangePreview() {
    CryptoTrackerTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            PriceChange(
                change = DisplayableNumber(
                    value = 2.43,
                    formatted = "2.43"
                )
            )
            PriceChange(
                change = DisplayableNumber(
                    value = -2.43,
                    formatted = "-2.43"
                )
            )
        }
    }
}