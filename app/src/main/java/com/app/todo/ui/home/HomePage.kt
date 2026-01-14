package com.app.todo.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.todo.ui.navigation.NavigationDestination
import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.app.todo.ui.appbar.TopAppBar

object HomeDestination: NavigationDestination {
    override val route = "home"
}

@Composable
fun HomePage(modifier: Modifier = Modifier,
             onNewEntry: () -> Unit) {

    BackHandler(
        enabled = false,
        onBack = {

        }
    )

    // menu opened?
    var isMenuOpen by remember { mutableStateOf(false) }

    // if menu opened -> darken the screen
    val scrimAlpha by animateFloatAsState(
        targetValue = if (isMenuOpen) 0.6f else 0f,
        label = "ScrimAnimation"
    )

    val angle: Float = 45F

    val animatedRotation by animateFloatAsState(
        targetValue = if (isMenuOpen) angle else 0f,
        animationSpec = tween(durationMillis = 400),
        label = "RotationAnimation"
    )
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = "ToDo App",
                    onClick = {},
                    icon = Icons.Filled.Create
                )
            },
            floatingActionButton = {
                Column(
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = modifier
                        .padding(end = 32.dp, bottom = 32.dp),
                ) {
                    // 1. The Animated Menu
                    AnimatedVisibility(
                        visible = isMenuOpen,
                        enter = fadeIn(tween(300)) + expandVertically(expandFrom = Alignment.Bottom),
                        exit = fadeOut(tween(300)) + shrinkVertically(shrinkTowards = Alignment.Bottom)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.End,
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            MenuButton(onClick = {
                                onNewEntry()
                            }, text = "New", icon=Icons.Filled.Add)
                            MenuButton(onClick = { /* ... */ }, text = "Done", icon=Icons.Filled.Done)
                            MenuButton(onClick = { /* ... */ }, text = "Calendar", icon=Icons.Filled.DateRange)

                        }
                    }

                    FloatingActionButton(
                        onClick = {
                            isMenuOpen = !isMenuOpen
                        },
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.outline,
                        shape = MaterialTheme.shapes.extraLarge,
                        modifier = Modifier
                            .rotate(animatedRotation)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Add,
                            contentDescription = "Add new ToDo-entry."
                        )
                    }
                }
            }
        ) {
            if (scrimAlpha > 0f) {
                Box(
                    modifier = modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = scrimAlpha))
                        .pointerInput(Unit) {
                            detectTapGestures { isMenuOpen = false }
                        }
                ) {
                    ShowEntries()

                }
            }
        }
    }
}

@Composable
private fun MenuButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    icon: ImageVector
) {
    SmallFloatingActionButton(
        onClick = {
            onClick()
        },
        modifier = modifier.padding(end=10.dp, bottom=5.dp, top=5.dp),
        contentColor = MaterialTheme.colorScheme.outline,
        containerColor = MaterialTheme.colorScheme.tertiary,
        shape = MaterialTheme.shapes.small,
        ) {
        Row {
            Icon(imageVector = icon, contentDescription = "New",
                modifier = modifier.padding(top=5.dp, end=5.dp, start=5.dp, bottom=5.dp))
            Spacer(modifier = modifier.width(5.dp))
            Text(text,
                modifier = modifier.padding(top=5.dp, end=5.dp, start=5.dp, bottom=5.dp),)
        }
    }
}

@Composable
private fun ShowEntries(modifier: Modifier = Modifier) {

}