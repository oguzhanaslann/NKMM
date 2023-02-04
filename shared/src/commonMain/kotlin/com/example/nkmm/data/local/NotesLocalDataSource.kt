package com.example.nkmm.data.local

import app.cash.sqldelight.Query
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.nkmm.db.NOTE
import com.example.nkmm.db.NoteQueries
import com.example.nkmm.note.NoteOverview
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

interface NotesLocalDataSource {
    fun getNoteList(coroutineContext: CoroutineContext): Flow<List<NOTE>>
    suspend fun addNote(noteOverview: NoteOverview)
    suspend fun deleteNote(id: String)
}

internal class NotesLocalDataSourceImpl(
    private val noteQueries: NoteQueries
) : NotesLocalDataSource {
    override fun getNoteList(coroutineContext: CoroutineContext): Flow<List<NOTE>> {
        return noteQueries.getNote()
            .asFlow()
            .mapToList(coroutineContext)
    }


    override suspend fun addNote(noteOverview: NoteOverview) {
        noteQueries.transaction {
            noteQueries.addNote(
                id = noteOverview.id,
                title = noteOverview.title,
                content = noteOverview.content
            )
        }
    }

    override suspend fun deleteNote(id: String) {
        noteQueries.transaction {
            noteQueries.deleteNote(
                id = id
            )
        }
    }
}