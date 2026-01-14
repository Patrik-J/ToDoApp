package com.app.todo.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.todo.ui.entry.NewEntryDestination
import com.app.todo.ui.entry.NewEntryPage
import com.app.todo.ui.home.HomeDestination
import com.app.todo.ui.home.HomePage

@Composable
fun ToDoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ) {
        composable(
            route = HomeDestination.route
        ) {
            HomePage(
                modifier = modifier,
                onNewEntry = {
                    navController.navigate(route = NewEntryDestination.route)
                }
            )
        }
        composable(
            route = NewEntryDestination.route
        ) {
            NewEntryPage(
                modifier = modifier,
                onBack = {
                    navController.navigate(route = HomeDestination.route)

                }
            )
        }
    }
}