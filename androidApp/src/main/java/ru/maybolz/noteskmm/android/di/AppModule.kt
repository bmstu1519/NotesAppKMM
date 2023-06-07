package ru.maybolz.noteskmm.android.di

import android.app.Application
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.maybolz.noteskmm.data.local.DatabaseDriverFactory
import ru.maybolz.noteskmm.data.note.SqlDelightNoteDataSource
import ru.maybolz.noteskmm.database.NoteDatabase
import ru.maybolz.noteskmm.domain.note.NoteDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(driver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(NoteDatabase(driver))
    }

}