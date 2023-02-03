package com.example.nkmm.di

import com.example.nkmm.NoteListUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val commonModule = module {
    factory {
        NoteListUseCase()
    }
}