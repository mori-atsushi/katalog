package jp.co.cyberagent.katalog.androidsample.compose.material

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun SampleSlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Text(text = sliderPosition.toString())
    Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
}

@Composable
fun SampleSliderWithSteps() {
    var sliderPosition by remember { mutableStateOf(0f) }
    Text(text = sliderPosition.toString())
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 0f..100f,
        onValueChangeFinished = {
            // launch some business logic update with the state you hold
            // viewModel.updateSelectedSliderValue(sliderPosition)
        },
        steps = 5,
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colors.secondary,
            activeTrackColor = MaterialTheme.colors.secondary
        )
    )
}
