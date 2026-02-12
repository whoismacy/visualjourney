package com.whoismacy.android.visual_journey.visualjourneyui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.whoismacy.android.visual_journey.ui.theme.VisualJourneyTheme

@Composable
fun HomeScreen(windowSizeClass: WindowSizeClass) {
    VisualJourneyTheme {
        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                HomePortrait()
            }

            WindowWidthSizeClass.Expanded -> {
                HomeLandScape()
            }
        }
    }
}

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Column(
        modifier.verticalScroll(rememberScrollState()),
    ) { }
}

@Composable
fun HomeLandScape() {
    Surface(
        color = MaterialTheme.colorScheme.background,
    ) {
        Row {
            NavigationRail()
        }
    }
}

@Composable
fun HomePortrait() {
    Scaffold(
        bottomBar = {
            BottomNavigationBar()
        },
    ) { innerPadding ->
        HomePage(modifier = Modifier.padding(innerPadding))
    }
}
