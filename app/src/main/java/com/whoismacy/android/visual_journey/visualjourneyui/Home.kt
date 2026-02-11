package com.whoismacy.android.visual_journey.visualjourneyui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.whoismacy.android.visual_journey.R
import com.whoismacy.android.visual_journey.ui.theme.VisualJourneyTheme

@Composable
fun Homepage(windowSizeClass: WindowSizeClass) {
    VisualJourneyTheme {
        when (windowSizeClass.widthSizeClass) {
            WindowWidthSizeClass.Compact -> {
                BottomNavigationBar()
            }

            WindowWidthSizeClass.Expanded -> {
                NavigationRail()
            }
        }
    }
}

@Composable
fun BottomNavigationBar(modifier: Modifier = Modifier) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {},
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null,
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_history))
            },
            selected = false,
            onClick = {},
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_account))
            },
            selected = false,
            onClick = {},
        )
    }
}

@Composable
fun NavigationRail(modifier: Modifier = Modifier) {
    NavigationRail(modifier = Modifier) {
        NavigationRailItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = false,
            onClick = {},
        )

        NavigationRailItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null,
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_history))
            },
            selected = false,
            onClick = {},
        )

        NavigationRailItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                )
            },
            label = {
                Text(
                    stringResource(R.string.botton_mavigation_account),
                )
            },
            selected = false,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationRailPreview() {
    NavigationRail()
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    BottomNavigationBar()
}
