package com.alanaoliv.todoapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alanaoliv.todoapp.domain.model.Tarefa
import com.alanaoliv.todoapp.domain.usecase.AtualizarEstadoTarefaUseCase
import com.alanaoliv.todoapp.domain.usecase.AtualizarTarefaUseCase
import com.alanaoliv.todoapp.domain.usecase.CriarTarefaUseCase
import com.alanaoliv.todoapp.domain.usecase.DeletarTarefaUseCase
import com.alanaoliv.todoapp.domain.usecase.ListarTodasTarefasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TarefaViewModel @Inject constructor(
    private val criarTarefa: CriarTarefaUseCase,
    private val listarTodasTarefas: ListarTodasTarefasUseCase,
    private val atualizarTarefa: AtualizarTarefaUseCase,
    private val atualizarEstadoTarefa: AtualizarEstadoTarefaUseCase,
    private val deletarTarefa: DeletarTarefaUseCase
) : ViewModel() {

    private val _tarefas = MutableStateFlow<List<Tarefa>>(emptyList())

    val tarefas: StateFlow<List<Tarefa>> = _tarefas

    fun carregarTarefas() {
        viewModelScope.launch {
            _tarefas.value = listarTodasTarefas()
        }
    }

    fun criarNovaTarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            criarTarefa(tarefa)
            carregarTarefas()
        }
    }

    fun atualizarTarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            atualizarTarefa(tarefa)
            carregarTarefas()
        }
    }

    fun atualizarFeito(tarefa: Tarefa, feita: Boolean) {
        viewModelScope.launch {
            atualizarEstadoTarefa(tarefa, feita)
            carregarTarefas()
        }
    }

    fun deletarTarefa(tarefa: Tarefa) {
        viewModelScope.launch {
            deletarTarefa(tarefa)
            carregarTarefas()
        }
    }
}
