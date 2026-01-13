package com.app.todo.theme

import androidx.compose.runtime.Composable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme

private val LightColorScheme = lightColorScheme(
    background = background_light,
    primary = primary_light,
    secondary = secondary_light,
    tertiary = tertiary_light,
    outline = outline_light,
    outlineVariant = outlineVariant_light,
    onError = onError_light
)

private val DarkColorScheme = darkColorScheme(
    background = background_dark,
    primary = primary_dark,
    secondary = secondary_dark,
    tertiary = tertiary_dark,
    outline = outline_dark,
    outlineVariant = outlineVariant_dark,
    onError = onError_dark
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when (darkTheme) {
        true -> DarkColorScheme
        false -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        shapes = Shapes,
        content = content
    )
}