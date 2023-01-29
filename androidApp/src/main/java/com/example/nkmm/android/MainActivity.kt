package com.example.nkmm.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.nkmm.note.NoteOverview
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NKMMTheme {
                MainScreen()
            }
        }
    }
}

class NoteViewModel() : ViewModel() {
    val notes = MutableStateFlow<List<NoteOverview>>(emptyList())

    init {
        notes.value = listOf(
            NoteOverview("1", "Title 1", "Content 1"),
            NoteOverview("2", "Title 2", "Content 2")
        )
    }
}

const val CREATE_NOTE_ROUTE = "AddNote"
const val NOTES_ROUTE = "Notes"
const val NOTE_ROUTE = "Note/{noteId}"

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,

) {
    val navController = rememberNavController()
    NavHost(navController = navController , startDestination = NOTES_ROUTE ) {
        composable(NOTES_ROUTE) {
            val viewModel = NoteViewModel()
            val notes by viewModel.notes.collectAsState()
            MainScreenContent(
                modifier = modifier,
                notes = notes,
                onAddNoteClicked = {
                    navController.navigate(CREATE_NOTE_ROUTE)
                }
            )
        }

        composable(
            NOTE_ROUTE,
            arguments = listOf(navArgument("noteId") { type = NavType.StringType })
        ) { backStackEntry ->
            require(backStackEntry.arguments != null)
            val noteId = backStackEntry.arguments!!.getString("noteId")
            require(noteId != null)
        }

        composable(CREATE_NOTE_ROUTE) {
            CreateNoteView()
        }
    }
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    notes: List<NoteOverview>,
    onAddNoteClicked: () -> Unit = {}
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Box {
            NoteOverviewList(
                modifier = Modifier.fillMaxWidth(),
                notes = notes
            )

            FloatingActionButton(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                onClick = onAddNoteClicked
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add new item")
            }
        }
    }
}


@Preview
@Composable
fun DefaultPreview() {
    NKMMTheme {
        MainScreenContent(
            notes = listOf(
                NoteOverview("1", "Title 1", "Content 1"),
                NoteOverview("2", "Title 2", "Content 2")
            )
        )
    }
}


@Composable
fun NoteOverviewItem(
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier),
        shape = MaterialTheme.shapes.medium,
        contentColor = MaterialTheme.colors.onSurface,
        backgroundColor = MaterialTheme.colors.surface,
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Hello World",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "Hello World description",
                style = MaterialTheme.typography.body2,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
fun previewNoteOverview() {
    NKMMTheme {
        NoteOverviewItem()
    }
}

@Composable
fun NoteOverviewList(
    modifier: Modifier = Modifier,
    notes: List<NoteOverview>
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            items = notes,
            key = { item -> item.id },
        ) { item ->
            NoteOverviewItem()
        }
    }
}

