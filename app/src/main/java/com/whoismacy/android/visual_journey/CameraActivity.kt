package com.whoismacy.android.visual_journey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.whoismacy.android.visual_journey.ui.theme.VisualJourneyTheme
import com.whoismacy.android.visual_journey.visualjourneyui.CaptureJournalCamera
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CameraActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisualJourneyTheme {
                DisplayCamera()
            }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, CameraActivity::class.java)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayCamera() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
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
                CaptureJournalCamera(modifier = Modifier.fillMaxSize())
                Row(
                    modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }
}
