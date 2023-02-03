package com.example.nkmm

import com.example.nkmm.note.NoteOverview

class NoteListUseCase{
    private val list = mutableListOf(
        NoteOverview("1", "Title 1", "Content 1"),
        NoteOverview("2", "Title 2", "Content 2")
    )

    fun getNoteList(): List<NoteOverview> {
        return list
    }

    fun addNote(noteOverview: NoteOverview) {
        list.add(noteOverview)
    }

    fun deleteNote(id: String) {
        list.find { it.id == id }?.let { list.remove(it) }
    }

    companion object {
        val instance = NoteListUseCase()
    }
    
}