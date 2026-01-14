package com.app.todo

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.todo.ui.navigation.ToDoNavHost

@Composable
fun ToDoApp(navController: NavHostController = rememberNavController()) {
    ToDoNavHost(navController = navController)
}