package com.alanaoliv.todoapp.di

import com.alanaoliv.todoapp.domain.repository.TarefaRepository
import com.alanaoliv.todoapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideCriarTarefaUseCase(repository: TarefaRepository): CriarTarefaUseCase {
        return CriarTarefaUseCase(repository)
    }

    @Provides
    fun provideListarTodasTarefasUseCase(repository: TarefaRepository): ListarTodasTarefasUseCase {
        return ListarTodasTarefasUseCase(repository)
    }

    @Provides
    fun provideAtualizarTarefaUseCase(repository: TarefaRepository): AtualizarTarefaUseCase {
        return AtualizarTarefaUseCase(repository)
    }

    @Provides
    fun provideAtualizarEstadoTarefaUseCase(repository: TarefaRepository): AtualizarEstadoTarefaUseCase {
        return AtualizarEstadoTarefaUseCase(repository)
    }

    @Provides
    fun provideDeletarTarefaUseCase(repository: TarefaRepository): DeletarTarefaUseCase {
        return DeletarTarefaUseCase(repository)
    }
}
