package ru.maybolz.noteskmm.data.note

import ru.maybolz.noteskmm.database.NoteDatabase
import ru.maybolz.noteskmm.domain.note.Note
import ru.maybolz.noteskmm.domain.note.NoteDataSource
import ru.maybolz.noteskmm.domain.time.DateTimeUtil

class SqlDelightNoteDataSource(
    db: NoteDatabase
): NoteDataSource {

    private val queries = db.noteQueries

    override suspend fun insertNote(note: Note) {
        queries.insertNote(
            id = note.id ,
            title = note.title ,
            content = note.content ,
            colorHex = note.colorHex ,
            created = DateTimeUtil.toEpochMillis(note.created)
        )
    }

    override suspend fun getNoteById(id: Long): Note? =
        queries.getNoteById(id)
            .executeAsOneOrNull()
            ?.toNote()

    override suspend fun getAllNotes(): List<Note> =
        queries.getAllNotes()
            .executeAsList()
            .map { it.toNote() }

    override suspend fun deleteNoteById(id: Long) =
        queries.deleteNoteById(id)
}