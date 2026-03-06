package com.whoismacy.android.visual_journey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import com.whoismacy.android.visual_journey.ui.theme.VisualJourneyTheme

class HistoryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            VisualJourneyTheme {
                SimpleExample()
            }
        }
    }

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, HistoryActivity::class.java)
    }
}

@Composable
fun SimpleExample(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier =
                modifier
                    .size(150.dp)
                    .padding(20.dp)
                    .background(Color.Red)
                    .padding(20.dp)
                    .background(Color.Green)
                    .padding(20.dp)
                    .background(Color.Blue),
        ) {
            Text("I'm a box")
        }
    }
}
