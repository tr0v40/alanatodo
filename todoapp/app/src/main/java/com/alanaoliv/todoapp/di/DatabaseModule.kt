package com.alanaoliv.todoapp.di

import android.content.Context
import androidx.room.Room
import com.alanaoliv.todoapp.data.local.TarefaDao
import com.alanaoliv.todoapp.data.local.TarefaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(appContext: Context): TarefaDatabase {
        return Room.databaseBuilder(
            appContext,
            TarefaDatabase::class.java,
            "tarefas_db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideTarefaDao(database: TarefaDatabase): TarefaDao {
        return database.tarefaDao()
    }
}
