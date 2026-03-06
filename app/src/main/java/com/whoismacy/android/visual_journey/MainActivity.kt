package com.whoismacy.android.visual_journey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.whoismacy.android.visual_journey.model.HabitRepository
import com.whoismacy.android.visual_journey.ui.theme.VisualJourneyTheme
import com.whoismacy.android.visual_journey.view.HomeScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        HabitRepository.initialize(this)
        setContent {
            VisualJourneyTheme {
                val windowSizeClass = calculateWindowSizeClass(this)
                HomeScreen(windowSizeClass)
            }
        }
    }
}
