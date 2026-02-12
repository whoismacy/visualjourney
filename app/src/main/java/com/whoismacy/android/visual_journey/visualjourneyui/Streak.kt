package com.whoismacy.android.visual_journey.visualjourneyui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun Streak(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "24",
            style = MaterialTheme.typography.titleLargeEmphasized,
        )
        Text(
            text = "Days Streak",
            style = MaterialTheme.typography.titleMedium,
        )
    }
}
