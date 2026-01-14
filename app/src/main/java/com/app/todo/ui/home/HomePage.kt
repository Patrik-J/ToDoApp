package com.app.todo.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.todo.ui.navigation.NavigationDestination
import androidx.activity.compose.BackHandler
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

object HomeDestination: NavigationDestination {
    override val route = "home"
}

@Composable
fun HomePage(modifier: Modifier = Modifier) {

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

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            topBar = {
                ToDoAppBar("ToDo App")
            },
            floatingActionButton = {
                RotatingMenuButton(
                    angle = 45f,
                    isPressed = isMenuOpen,
                    onToggle = { isMenuOpen = !isMenuOpen },
                    onClick = { /* Toggle logic only */ }
                )
            }
        ) {

        }
    }
}

@Composable
private fun RotatingMenuButton(
    angle: Float,
    isPressed: Boolean,
    onToggle: () -> Unit,
    onClick: () -> Unit
) {
    val animatedRotation by animateFloatAsState(
        targetValue = if (isPressed) angle else 0f,
        animationSpec = tween(durationMillis = 300),
        label = "RotationAnimation"
    )

    FloatingActionButton(
        onClick = {
            onToggle()
            onClick()
        },
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.outline,
        shape = MaterialTheme.shapes.extraLarge,
        modifier = Modifier
            .offset(-30.dp, -30.dp)
            .rotate(animatedRotation)
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add new ToDo-entry."
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToDoAppBar(
    title: String
) {
    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.outline
        ),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.offset(x = -15.dp)
            ) {
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = "MainIcon",
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(
                    modifier = Modifier.width(12.dp)
                )
                Text(text = title,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleLarge)
            }
        }
    )
}

