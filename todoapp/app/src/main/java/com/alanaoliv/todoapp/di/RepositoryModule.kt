package com.alanaoliv.todoapp.di

import com.alanaoliv.todoapp.data.repository.TarefaRepositoryImpl
import com.alanaoliv.todoapp.domain.repository.TarefaRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindTarefaRepository(
        tarefaRepositoryImpl: TarefaRepositoryImpl
    ): TarefaRepository
}
