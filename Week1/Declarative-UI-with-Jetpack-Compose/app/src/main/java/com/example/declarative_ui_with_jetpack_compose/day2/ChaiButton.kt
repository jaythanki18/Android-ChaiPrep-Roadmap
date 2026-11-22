package com.example.declarative_ui_with_jetpack_compose.day2

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.declarative_ui_with_jetpack_compose.ui.theme.DeclarativeUIwithJetpackComposeTheme

enum class ChaiButtonStyle { Filled, Outlined }

// Custom modifier: an extension function that chains existing modifiers.
fun Modifier.chaiElevated(enabled: Boolean = true): Modifier =
    this.shadow(if (enabled) 4.dp else 0.dp, RoundedCornerShape(24.dp))

// Custom modifier: dims the component when it is disabled.
fun Modifier.dimWhen(dimmed: Boolean): Modifier = this.alpha(if (dimmed) 0.5f else 1f)

// Reusable and stateless: the caller owns the click behaviour.
@Composable
fun ChaiButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: ChaiButtonStyle = ChaiButtonStyle.Filled,
    enabled: Boolean = true
) {
    val shape = RoundedCornerShape(24.dp)
    val buttonModifier = modifier
        .defaultMinSize(minWidth = 120.dp)
        .dimWhen(!enabled)

    when (style) {
        ChaiButtonStyle.Filled -> Button(
            onClick = onClick,
            enabled = enabled,
            shape = shape,
            modifier = buttonModifier.chaiElevated(enabled)
        ) { Text(text) }

        ChaiButtonStyle.Outlined -> OutlinedButton(
            onClick = onClick,
            enabled = enabled,
            shape = shape,
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
            colors = ButtonDefaults.outlinedButtonColors(),
            modifier = buttonModifier
        ) { Text(text) }
    }
}

// Previews: different styles/states, plus dark mode, large font and a different locale-sized label.
@Preview(name = "Filled", showBackground = true)
@Composable
private fun ChaiButtonFilledPreview() {
    DeclarativeUIwithJetpackComposeTheme {
        ChaiButton(text = "Brew", onClick = {}, modifier = Modifier.padding(16.dp))
    }
}

@Preview(name = "Outlined", showBackground = true)
@Composable
private fun ChaiButtonOutlinedPreview() {
    DeclarativeUIwithJetpackComposeTheme {
        ChaiButton(
            text = "Brew",
            onClick = {},
            style = ChaiButtonStyle.Outlined,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(name = "Disabled", showBackground = true)
@Composable
private fun ChaiButtonDisabledPreview() {
    DeclarativeUIwithJetpackComposeTheme {
        ChaiButton(text = "Brew", onClick = {}, enabled = false, modifier = Modifier.padding(16.dp))
    }
}

@Preview(name = "Dark", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ChaiButtonDarkPreview() {
    DeclarativeUIwithJetpackComposeTheme(darkTheme = true) {
        ChaiButton(text = "Brew", onClick = {}, modifier = Modifier.padding(16.dp))
    }
}

@Preview(name = "Large font", showBackground = true, fontScale = 1.8f)
@Composable
private fun ChaiButtonLargeFontPreview() {
    DeclarativeUIwithJetpackComposeTheme {
        ChaiButton(text = "Brew a long cup", onClick = {}, modifier = Modifier.padding(16.dp))
    }
}

// Combined @Preview annotations on one function render every configuration at once.
@Preview(name = "Light", showBackground = true)
@Preview(name = "Night", showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ChaiButtonAllStylesPreview() {
    DeclarativeUIwithJetpackComposeTheme {
        Column(modifier = Modifier.padding(16.dp)) {
            ChaiButton(text = "Filled", onClick = {})
            ChaiButton(text = "Outlined", onClick = {}, style = ChaiButtonStyle.Outlined)
        }
    }
}
