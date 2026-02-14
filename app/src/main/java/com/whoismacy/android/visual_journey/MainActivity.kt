package com.whoismacy.android.visual_journey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import com.whoismacy.android.visual_journey.ui.theme.VisualJourneyTheme
import com.whoismacy.android.visual_journey.visualjourneyui.HomeScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisualJourneyTheme {
                val windowSizeClass = calculateWindowSizeClass(this)
                HomeScreen(windowSizeClass)
            }
        }
    }
}

@Composable
fun DisplayCamera() {}
