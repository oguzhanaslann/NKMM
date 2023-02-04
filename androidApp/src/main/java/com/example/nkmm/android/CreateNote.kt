package com.example.nkmm.android

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.nkmm.NoteListUseCase
import com.example.nkmm.NoteViewModel
import com.example.nkmm.note.NoteOverview
import org.koin.androidx.compose.koinViewModel

@Composable
fun CreateNoteView(
    noteViewModel: NoteViewModel = koinViewModel(),
    onNoteCreate: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            val title = remember {
                mutableStateOf("")
            }

            val content = remember {
                mutableStateOf("")
            }

            Text(text = "Title")
            TextField(
                value = title.value,
                onValueChange = {
                    title.value = it
                }
            )
            Text(text = "Content")
            TextField(
                value = content.value,
                onValueChange = {
                    content.value = it
                }
            )

            Button(onClick = {
                noteViewModel
                    .addNote(
                        title = title.value,
                        content = content.value
                    )
                onNoteCreate()
            }) {
                Text(text = "Save")
            }
        }


    }
}

@Preview
@Composable
fun previewCreateNoteView() {
    NKMMTheme {
        CreateNoteView { }
    }
}