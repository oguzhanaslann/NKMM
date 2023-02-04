package com.example.nkmm

import com.example.nkmm.data.local.NotesLocalDataSource
import com.example.nkmm.note.NoteOverview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteListUseCase(
    private val notesLocalDataSource: NotesLocalDataSource
) {

    fun getNoteList(): Flow<List<NoteOverview>> {
        return notesLocalDataSource.getNoteList().map {
            it.map { note ->
                NoteOverview(
                    id = note.id,
                    title = note.title.orEmpty(),
                    content = note.content.orEmpty()
                )
            }
        }
    }

    suspend fun addNote(noteOverview: NoteOverview) {
        notesLocalDataSource.addNote(noteOverview)
    }

    suspend fun deleteNote(id: String) {
        notesLocalDataSource.deleteNote(id)
    }
}