package com.example.nkmm.di

import com.example.nkmm.NoteListUseCase
import com.example.nkmm.data.local.NotesLocalDataSource
import com.example.nkmm.data.local.NotesLocalDataSourceImpl
import com.example.nkmm.db.NkmmDb
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val NKMM_DB_DI_NAME = "NkmmDb"
private const val NOTE_QUERIES_DI_NAME = "NoteQueries"
private const val NOTES_LOCAL_DATA_SOURCE_DI_NAME = "NotesLocalDataSource"

val commonModule = module {

    factory(named(NOTE_QUERIES_DI_NAME)) {
        get<NkmmDb>(named(NKMM_DB_DI_NAME)).noteQueries
    }

    factory<NotesLocalDataSource>(named(NOTES_LOCAL_DATA_SOURCE_DI_NAME)) {
        NotesLocalDataSourceImpl(
            noteQueries = get(named(NOTE_QUERIES_DI_NAME))
        )
    }


    factory {
        NoteListUseCase(
            notesLocalDataSource = get(named(NOTES_LOCAL_DATA_SOURCE_DI_NAME))
        )
    }
}