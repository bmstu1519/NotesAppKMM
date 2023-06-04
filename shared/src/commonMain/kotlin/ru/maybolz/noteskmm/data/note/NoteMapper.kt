package ru.maybolz.noteskmm.data.note

import database.NoteEntity
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import ru.maybolz.noteskmm.domain.note.Note

fun NoteEntity.toNote(): Note {
    return Note(
        id = id ,
        title = title ,
        content = content ,
        colorHex = colorHex ,
        created = Instant
            .fromEpochMilliseconds(created)
            .toLocalDateTime(TimeZone.currentSystemDefault())
    )
}