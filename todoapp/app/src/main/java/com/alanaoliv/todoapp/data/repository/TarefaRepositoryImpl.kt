package com.alanaoliv.todoapp.data.repository

import com.alanaoliv.todoapp.data.local.TarefaDao
import com.alanaoliv.todoapp.data.mapper.toDomain
import com.alanaoliv.todoapp.data.mapper.toEntity
import com.alanaoliv.todoapp.domain.model.Tarefa
import com.alanaoliv.todoapp.domain.repository.TarefaRepository

class TarefaRepositoryImpl(
    private val tarefaDao: TarefaDao
) : TarefaRepository {

    override suspend fun criar(tarefa: Tarefa) {
        tarefaDao.criar(tarefa.toEntity())
    }

    override suspend fun listarTodas(): List<Tarefa> {
        return tarefaDao.listarTodas().map { it.toDomain() }
    }

    override suspend fun atualizar(tarefa: Tarefa) {
        tarefaDao.atualizar(tarefa.toEntity())
    }

    override suspend fun deletar(tarefa: Tarefa) {
        tarefaDao.deletar(tarefa.toEntity())
    }
}
