package com.example.declarative_ui_with_jetpack_compose.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = ChaiBrown80,
    onPrimary = ChaiBrownContainer80,
    primaryContainer = ChaiBrownContainer80,
    onPrimaryContainer = ChaiBrownContainer40,
    secondary = Cardamom80,
    tertiary = Saffron80,
    background = Espresso,
    onBackground = OnEspresso,
    surface = Espresso,
    onSurface = OnEspresso
)

private val LightColorScheme = lightColorScheme(
    primary = ChaiBrown40,
    primaryContainer = ChaiBrownContainer40,
    onPrimaryContainer = ChaiBrownContainer80,
    secondary = Cardamom40,
    tertiary = Saffron40,
    background = Cream,
    onBackground = OnCream,
    surface = Cream,
    onSurface = OnCream
)

@Composable
fun DeclarativeUIwithJetpackComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Off by default so the custom chai palette shows; set true to use Android 12+ wallpaper colors.
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
