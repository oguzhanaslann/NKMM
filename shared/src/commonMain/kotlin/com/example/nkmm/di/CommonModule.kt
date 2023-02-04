package com.example.nkmm.di

import com.example.nkmm.NoteListUseCase
import com.example.nkmm.data.local.NotesLocalDataSource
import com.example.nkmm.data.local.NotesLocalDataSourceImpl
import com.example.nkmm.db.NkmmDb
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val NkmmDbDiName = "NkmmDb"
private const val NoteQueriesDiName = "NoteQueries"
private const val NotesLocalDataSourceDiName = "NotesLocalDataSource"

val commonModule = module {

    factory(named(NoteQueriesDiName)) {
        get<NkmmDb>(named(NkmmDbDiName)).noteQueries
    }

    factory<NotesLocalDataSource>(named(NotesLocalDataSourceDiName)) {
        NotesLocalDataSourceImpl(
            noteQueries = get(named(NoteQueriesDiName))
        )
    }


    factory {
        NoteListUseCase(
            notesLocalDataSource = get(named(NotesLocalDataSourceDiName))
        )
    }
}