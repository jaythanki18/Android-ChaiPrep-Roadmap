package com.example.declarative_ui_with_jetpack_compose.day1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.declarative_ui_with_jetpack_compose.ui.theme.DeclarativeUIwithJetpackComposeTheme

// Stateless: receives the value and reports events; owns no state.
@Composable
fun Counter(
    count: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = onDecrement, enabled = count > 0) { Text("-") }
        Text(text = "Count: $count")
        Button(onClick = onIncrement) { Text("+") }
    }
}

// Stateful: owns the state and hoists it into the stateless Counter.
@Composable
fun CounterScreen(modifier: Modifier = Modifier) {
    // rememberSaveable survives rotation; plain remember would not.
    var count by rememberSaveable { mutableIntStateOf(0) }
    Counter(
        count = count,
        onIncrement = { count++ },
        onDecrement = { count-- },
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
private fun CounterPreview() {
    DeclarativeUIwithJetpackComposeTheme {
        Counter(count = 3, onIncrement = {}, onDecrement = {})
    }
}

@Preview(showBackground = true)
@Composable
private fun CounterScreenPreview() {
    DeclarativeUIwithJetpackComposeTheme { CounterScreen() }
}
