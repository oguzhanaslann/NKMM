package com.example.nkmm.android.di

import com.example.nkmm.NoteListUseCase
import com.example.nkmm.NoteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        NoteViewModel(
            get<NoteListUseCase>()
        )
    }
}