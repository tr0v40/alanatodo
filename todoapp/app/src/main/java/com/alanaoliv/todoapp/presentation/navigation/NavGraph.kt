package com.alanaoliv.todoapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alanaoliv.todoapp.presentation.ui.screen.TarefaScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.ListaTarefas.route
    ) {
        composable(route = Screen.ListaTarefas.route) {
            TarefaScreen()
        }
    }
}
