package ru.maybolz.noteskmm.data.di

import ru.maybolz.noteskmm.data.local.DatabaseDriverFactory
import ru.maybolz.noteskmm.data.note.SqlDelightNoteDataSource
import ru.maybolz.noteskmm.database.NoteDatabase
import ru.maybolz.noteskmm.domain.note.NoteDataSource


class DatabaseModule {
    private val factory by lazy {
        DatabaseDriverFactory()
    }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}