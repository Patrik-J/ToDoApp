package com.app.todo.theme

import androidx.compose.ui.graphics.Color

val white = Color(0xFFFFFFFF)
val black = Color(0xFF000000)

// dark theme
val background_dark = Color(0xff144200)     // background coloring
val primary_dark = Color(0xff2f9564)        // top app bar
val secondary_dark = Color(0xff75cd73)      // primary buttons
val tertiary_dark = Color(0xff649b63)       // pop up menu buttons
val outline_dark = white                           // font coloring
val outlineVariant_dark = Color(0xff4b8072) // font for done date
val onError_dark = Color(0xff893737)        // font for overdue date/time

// light theme
val background_light = Color(0xff86bf99)
val primary_light = Color(0xff14c14d)
val secondary_light = Color(0xff7ceea2)
val tertiary_light = Color(0xffc4f1ba)
val outline_light = black
val outlineVariant_light = outlineVariant_dark
val onError_light = onError_dark

// priority coloring
val priority1 = Color(0xfffb8ac4)
val priority2 = Color(0xffc798d8)
val priority3 = Color(0xff9399e6)
val priority4 = Color(0xff93d6e6)
val priority5 = Color(0xffbce693)