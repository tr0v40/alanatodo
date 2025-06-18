package com.alanaoliv.todoapp.domain.usecase

import com.alanaoliv.todoapp.domain.model.Tarefa
import com.alanaoliv.todoapp.domain.repository.TarefaRepository

class CriarTarefaUseCase(private val repository: TarefaRepository) {
    suspend operator fun invoke(tarefa: Tarefa){
        repository.criar(tarefa)
    }
}

class ListarTodasTarefasUseCase(private val repository: TarefaRepository) {
    suspend operator fun invoke(): List<Tarefa>{
        return repository.listarTodas()
    }
}

class AtualizarTarefaUseCase(private val repository: TarefaRepository) {
    suspend operator fun invoke(tarefa: Tarefa){
        repository.atualizar(tarefa)
    }
}

class AtualizarEstadoTarefaUseCase(private val repository: TarefaRepository) {
    suspend operator fun invoke(tarefa: Tarefa, feita: Boolean){
        val novaTarefa = tarefa.copy(feito = feita)
        repository.atualizar(novaTarefa)
    }
}

class DeletarTarefaUseCase(private val repository: TarefaRepository) {
    suspend operator fun invoke(tarefa: Tarefa){
        repository.deletar(tarefa)
    }
}