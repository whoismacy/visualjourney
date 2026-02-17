package com.whoismacy.android.visual_journey

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.SwitchCamera
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.whoismacy.android.visual_journey.ui.theme.VisualJourneyTheme
import com.whoismacy.android.visual_journey.viewmodel.CameraPreviewViewModel
import com.whoismacy.android.visual_journey.visualjourneyui.CaptureJournalCamera
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

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
    val context = LocalContext.current
    val viewModel: CameraPreviewViewModel = hiltViewModel()
    val scaffoldState = rememberBottomSheetScaffoldState()
    val alphaValue = 0.8f
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
                Surface(
                    color = Color.Black.copy(alpha = alphaValue),
                ) {
                    Row(
                        modifier =
                            Modifier
                                .fillMaxWidth()
                                .padding(top = 32.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.SwitchCamera,
                                contentDescription = null,
                                tint = Color.White,
                            )
                        }
                    }
                }
                Surface(
                    color = Color.Black.copy(alpha = alphaValue),
                    modifier = Modifier.align(Alignment.BottomCenter),
                ) {
                    Row(
                        modifier =
                            Modifier
                                .height(120.dp)
                                .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        IconButton(onClick = {
                            viewModel.capturePhoto(context)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Camera,
                                contentDescription = null,
                                tint = Color.White,
                                modifier =
                                    Modifier
                                        .height(48.dp)
                                        .width(48.dp),
                            )
                        }
                    }
                }
            }
        }
    }
}
