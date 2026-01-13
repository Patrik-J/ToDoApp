package com.app.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.app.todo.theme.AppTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            val darkMode = false
            AppTheme(
                darkTheme = darkMode
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }

        }
    }
}