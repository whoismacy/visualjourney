package com.whoismacy.android.visual_journey

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.whoismacy.android.visual_journey.ui.theme.VisualJourneyTheme

class NewHabitActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisualJourneyTheme {
                HabitCard(
                    onClose = { finish() },
                )
            }
        }
    }

    companion object {
        fun createIntent(context: Context) = Intent(context, NewHabitActivity::class.java)
    }
}

@Composable
fun HabitCard(onClose: () -> Unit) {
    var shortHabitValue: String by rememberSaveable { mutableStateOf("") }
    var fullHabitValue: String by rememberSaveable { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
        contentAlignment = Alignment.Center,
    ) {
        Card(
            modifier =
                Modifier
                    .height(400.dp)
                    .width(375.dp),
            shape = MaterialTheme.shapes.large,
        ) {
            Column(
                Modifier.padding(20.dp),
            ) {
                Text(
                    text = "Short Habit Name",
                )
                TextField(
                    value = shortHabitValue,
                    onValueChange = { newText: String ->
                        shortHabitValue = newText
                    },
                    enabled = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    placeholder = { Text("e.g. 'Running' if your habit is running daily ") },
                    shape = MaterialTheme.shapes.medium,
                    label = { Text("Input short habit phrase") },
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Full Habit Description",
                )
                TextField(
                    value = fullHabitValue,
                    onValueChange = { newText: String ->
                        fullHabitValue = newText
                    },
                    enabled = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    placeholder = { Text("e.g. 'Take part in a daily 45 minute run'") },
                    shape = MaterialTheme.shapes.medium,
                    label = { Text("Enter the whole Habit phrase") },
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onClose() },
                ) {
                    Text(text = "Save")
                }
            }
        }
    }
}
