package com.whoismacy.android.visual_journey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.whoismacy.android.visual_journey.ui.theme.VisualJourneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisualJourneyTheme {}
        }
    }
}
