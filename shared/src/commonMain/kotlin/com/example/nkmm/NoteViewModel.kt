package com.example.nkmm

import com.example.nkmm.base.ViewModel
import com.example.nkmm.note.NoteOverview
import com.example.nkmm.util.randomUUID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

class NoteViewModel(
    private val list: NoteListUseCase
) : ViewModel() {
    val notes = MutableStateFlow<List<NoteOverview>>(emptyList())

    init {
        viewModelScope.launch {
            notes.emitAll(list.getNoteList(viewModelScope.coroutineContext))
        }
    }

    fun addNote(title: String, content: String) {
        viewModelScope.launch {
            list.addNote(
                NoteOverview(
                    id = randomUUID(),
                    title = title,
                    content = content
                )
            )
        }
    }
}