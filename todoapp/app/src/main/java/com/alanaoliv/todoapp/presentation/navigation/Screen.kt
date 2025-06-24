package com.alanaoliv.todoapp.presentation.navigation

sealed class Screen(val route: String) {
    object ListaTarefas : Screen("lista_tarefas")
}
