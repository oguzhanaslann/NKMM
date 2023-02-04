package com.example.nkmm.data.local

import com.example.nkmm.db.NOTE
import com.example.nkmm.db.NkmmDb
import com.example.nkmm.note.NoteOverview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

interface NotesLocalDataSource {
    fun getNoteList(): Flow<List<NOTE>>
    suspend fun addNote(noteOverview: NoteOverview)
    suspend fun deleteNote(id: String)
}

internal class NotesLocalDataSourceImpl(
    private val database : NkmmDb
) : NotesLocalDataSource {
    override fun getNoteList(): Flow<List<NOTE>> {
        return emptyFlow()
    }

    override suspend fun addNote(noteOverview: NoteOverview) {
//        TODO()
    }

    override suspend fun deleteNote(id: String) {
//        TODO()
    }
}