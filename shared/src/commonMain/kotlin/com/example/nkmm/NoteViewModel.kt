package com.example.nkmm

import com.example.nkmm.base.ViewModel
import com.example.nkmm.note.NoteOverview
import kotlinx.coroutines.flow.MutableStateFlow

class NoteViewModel(
    private val list: NoteListUseCase
) : ViewModel() {
    val notes = MutableStateFlow<List<NoteOverview>>(emptyList())

    init {
        notes.value = list.getNoteList()
    }

    fun refreshNotes() {
        notes.value = list.getNoteList()
    }

    fun addNote(title: String, content: String) {
        list.addNote(
            NoteOverview(
                id = "3",
                title = title,
                content = content
            )
        )
        refreshNotes()
    }
}