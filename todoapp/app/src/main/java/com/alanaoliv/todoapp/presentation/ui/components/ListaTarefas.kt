package com.alanaoliv.todoapp.presentation.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.alanaoliv.todoapp.domain.model.Tarefa
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ListaTarefas(
    tarefas: List<Tarefa>,
    onCheck: (Tarefa, Boolean) -> Unit,
    onEditar: (Tarefa) -> Unit,
    onDeletar: (Tarefa) -> Unit
) {
    LazyColumn {
        items(tarefas) { tarefa ->
            TarefaItem(
                tarefa = tarefa,
                onFeitoChange = { feito -> onCheck(tarefa, feito) },
                onEditar = { onEditar(tarefa) },
                onDeletar = { onDeletar(tarefa) }
            )
        }
    }
}