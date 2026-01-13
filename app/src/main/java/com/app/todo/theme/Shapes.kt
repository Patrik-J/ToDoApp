package com.app.todo.theme

import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(topStart = 4.dp, topEnd = 4.dp, bottomStart = 4.dp, bottomEnd = 4.dp),
    medium = RoundedCornerShape(topEnd = 8.dp, bottomStart = 8.dp),
    large = RoundedCornerShape(topEnd = 12.dp, bottomStart = 12.dp),
    extraLarge = RoundedCornerShape(topEnd = 8.dp, bottomStart = 8.dp, topStart = 8.dp, bottomEnd = 8.dp)
)