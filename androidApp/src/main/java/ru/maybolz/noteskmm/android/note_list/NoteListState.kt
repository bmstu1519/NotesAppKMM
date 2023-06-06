package ru.maybolz.noteskmm.android.note_list

import ru.maybolz.noteskmm.domain.note.Note

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val searchText: String = "",
    val isSearchActive: Boolean = false
)