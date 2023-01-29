package com.example.nkmm.note

data class NoteOverview(
    val id: String,
    val title: String,
    val content: String
) {
    fun isEmpty() = content.isEmpty()
}
