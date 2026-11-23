package com.example.declarative_ui_with_jetpack_compose.day6

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.declarative_ui_with_jetpack_compose.ui.theme.DeclarativeUIwithJetpackComposeTheme

// Custom progress bar drawn directly with DrawScope instead of composing Boxes.
@Composable
fun ChaiProgressBar(
    progress: Float,
    modifier: Modifier = Modifier,
    trackColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    fillColor: Color = MaterialTheme.colorScheme.primary,
    tickColor: Color = MaterialTheme.colorScheme.onPrimary,
) {
    // Animating the value (not the drawing) keeps the draw lambda a plain function of state.
    val animated by animateFloatAsState(progress.coerceIn(0f, 1f), label = "chaiProgress")

    Canvas(modifier = modifier.fillMaxWidth().height(14.dp)) {
        val radius = CornerRadius(size.height / 2)
        // Track
        drawRoundRect(color = trackColor, cornerRadius = radius)
        // Fill
        val fillWidth = size.width * animated
        if (fillWidth > 0f) {
            drawRoundRect(
                color = fillColor,
                size = Size(fillWidth, size.height),
                cornerRadius = radius,
            )
        }
        // Quarter ticks drawn over the fill
        for (i in 1..3) {
            val x = size.width * i / 4f
            if (x < fillWidth) {
                drawLine(
                    color = tickColor.copy(alpha = 0.6f),
                    start = Offset(x, size.height * 0.25f),
                    end = Offset(x, size.height * 0.75f),
                    strokeWidth = 2.dp.toPx(),
                    cap = StrokeCap.Round,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChaiProgressBarPreview() {
    DeclarativeUIwithJetpackComposeTheme {
        ChaiProgressBar(progress = 0.6f, modifier = Modifier.padding(16.dp))
    }
}
