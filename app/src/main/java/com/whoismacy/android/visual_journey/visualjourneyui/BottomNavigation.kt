package com.whoismacy.android.visual_journey.visualjourneyui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.whoismacy.android.visual_journey.R

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
    NavigationRail(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Column(
            modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
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
                    Text(stringResource(R.string.bottom_navigation_account))
                },
                selected = false,
                onClick = {},
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
private fun BottomNavigationPortraitPreview() {
    NavigationRail()
}

@Preview(widthDp = 640, heightDp = 360)
@Composable
private fun BottomNavigationLandScapePreview() {
    BottomNavigationBar()
}
