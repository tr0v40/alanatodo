package com.alanaoliv.todoapp.presentation.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alanaoliv.todoapp.domain.model.Tarefa
import com.alanaoliv.todoapp.presentation.viewmodel.TarefaViewModel

@Composable
fun TarefaScreen(viewModel: TarefaViewModel = hiltViewModel()) {
    val tarefas by viewModel.tarefas.collectAsState()
    var titulo by remember { mutableStateOf("") }
    var descricao by remember { mutableStateOf("") }

    LaunchedEffect(Unit) {
        viewModel.carregarTarefas()
    }

    Column(modifier = Modifier.padding(16.dp)) {

        OutlinedTextField(
            value = titulo,
            onValueChange = { titulo = it },
            label = { Text("Título da tarefa") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = descricao,
            onValueChange = { descricao = it },
            label = { Text("Descrição") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            viewModel.criarNovaTarefa(
                Tarefa(titulo = titulo, descricao = descricao)
            )
            titulo = ""
            descricao = ""
        }) {
            Text("Criar Tarefa")
        }

        Spacer(modifier = Modifier.height(16.dp))

        tarefas.forEach { tarefa ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = tarefa.titulo, style = MaterialTheme.typography.titleMedium)
                    Text(text = tarefa.descricao ?: "")

                    Row {
                        Checkbox(
                            checked = tarefa.feito,
                            onCheckedChange = { feito ->
                                viewModel.atualizarFeito(tarefa, feito)
                            }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(onClick = { viewModel.deletarTarefa(tarefa) }) {
                            Text("Deletar")
                        }
                    }
                }
            }
        }
    }
}

