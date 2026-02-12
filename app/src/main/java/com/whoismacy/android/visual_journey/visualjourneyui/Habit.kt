package com.whoismacy.android.visual_journey.visualjourneyui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.whoismacy.android.visual_journey.R

enum class CircleSize {
    Small,
    Large,
}

private val testingValues = listOf(true, false, true, false, null)

@Composable
fun Habit(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        shape = MaterialTheme.shapes.large,
        border = BorderStroke(1.dp, Color.LightGray),
        shadowElevation = 1.dp,
        modifier =
            modifier
                .height(64.dp),
    ) {
        Row(
            modifier =
                modifier
                    .width(360.dp)
                    .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            RadioButton(
                selected = false,
                onClick = {},
            )
            Text(
                stringResource(R.string.sample_habit),
            )
            HabitConsistencyRow()
        }
    }
}

@Composable
fun Circle(
    modifier: Modifier = Modifier,
    complete: Boolean? = null,
    size: CircleSize = CircleSize.Small,
) {
    val colour: Color =
        when (complete) {
            true -> Color.Green
            false -> Color.Red
            null -> Color.LightGray
        }

    val circleSize =
        when (size) {
            CircleSize.Small -> 12.dp
            CircleSize.Large -> 20.dp
        }

    Box(
        modifier =
            modifier
                .size(circleSize)
                .clip(CircleShape)
                .background(colour),
        contentAlignment = Alignment.Center,
    ) {}
}

@Composable
fun HabitConsistencyRow(habits: List<Boolean?> = testingValues) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.onSecondary,
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier =
                Modifier
                    .clip(CircleShape)
                    .padding(vertical = 8.dp, horizontal = 4.dp)
                    .width(96.dp),
        ) {
            items(habits) { item ->
                Circle(
                    complete = item,
                    size = CircleSize.Small,
                )
            }
        }
    }
}

@Preview
@Composable
fun HabitPreview() {
    Habit()
}
