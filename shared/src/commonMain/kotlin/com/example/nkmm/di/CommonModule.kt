package com.example.nkmm.di

import com.example.nkmm.NoteListUseCase
import com.example.nkmm.data.local.NotesLocalDataSource
import com.example.nkmm.data.local.NotesLocalDataSourceImpl
import com.example.nkmm.db.NkmmDb
import org.koin.core.qualifier.named
import org.koin.dsl.module

val NkmmDbDiName = "NkmmDb"
private const val NotesLocalDataSourceDiName = "NotesLocalDataSource"

val commonModule = module {

    factory<NotesLocalDataSource>(named(NotesLocalDataSourceDiName)) {
        NotesLocalDataSourceImpl(
            database = get<NkmmDb>(named(NkmmDbDiName))
        )
    }


    factory {
        NoteListUseCase(
            notesLocalDataSource = get(named(NotesLocalDataSourceDiName))
        )
    }
}