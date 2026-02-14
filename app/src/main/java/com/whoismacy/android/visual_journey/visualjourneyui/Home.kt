package com.whoismacy.android.visual_journey.visualjourneyui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier) {
    val showCamera = rememberSaveable { mutableStateOf(false) }
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier.verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(Modifier.height(16.dp))
            Streak()
            Spacer(Modifier.height(32.dp))
            Habit(showCamera = showCamera)
        }
        if (showCamera.value) {
            val scaffoldState = rememberBottomSheetScaffoldState()
            BottomSheetScaffold(
                sheetContent = {},
                sheetPeekHeight = 0.dp,
                sheetMaxWidth = 0.dp,
                scaffoldState = scaffoldState,
            ) { innerPadding ->
                Box(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                ) {
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = null,
                            )
                        }
                    }
                    CaptureJournalCamera(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun HomeLandScape() {
    Surface(
        color = MaterialTheme.colorScheme.background,
    ) {
        Row {
            NavigationRail()
            HomePage()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
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
