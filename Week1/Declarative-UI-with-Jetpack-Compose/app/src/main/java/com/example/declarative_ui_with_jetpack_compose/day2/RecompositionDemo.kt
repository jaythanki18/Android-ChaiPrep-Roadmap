package com.example.declarative_ui_with_jetpack_compose.day2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.declarative_ui_with_jetpack_compose.ui.theme.DeclarativeUIwithJetpackComposeTheme

// Shows what triggers recomposition: only composables that read the changed state re-run.
@Composable
fun RecompositionDemo(modifier: Modifier = Modifier) {
    var taps by remember { mutableIntStateOf(0) }
    var cups by remember { mutableIntStateOf(0) }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Reads `taps`, so it recomposes when taps changes.
        Text("Taps: $taps")
        // Reads `cups` only; the Text above and this one recompose independently.
        Text("Cups: $cups")
        ChaiButton(text = "Tap", onClick = { taps++ })
        ChaiButton(
            text = "Add cup",
            onClick = { cups++ },
            style = ChaiButtonStyle.Outlined,
            enabled = cups < 5
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RecompositionDemoPreview() {
    DeclarativeUIwithJetpackComposeTheme { RecompositionDemo() }
}
