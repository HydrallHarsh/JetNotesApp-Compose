package com.example.notesapp.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notesapp.R
import com.example.notesapp.components.NoteButton
import com.example.notesapp.components.NotesInputText
import com.example.notesapp.data.NotesDataSource
import com.example.notesapp.models.Note
import com.example.notesapp.utils.formatDate
import java.time.format.DateTimeFormatter
//import kotlin.coroutines.jvm.internal.CompletedContinuation.context

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(modifier: Modifier = Modifier,notes : List<Note>,onAddNote:(Note)->Unit,onRemoveNote:(Note)->Unit) {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    val context = LocalContext.current
    Column(modifier = Modifier.padding(6.dp)) {
        TopAppBar(title = { Text(text = stringResource(id = R.string.app_name)) }, actions = { Icon(
            imageVector = Icons.Rounded.Notifications,
            contentDescription = "Icon"
        )}, colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFDADFE3)))
        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            NotesInputText(modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),text = title, label = "Title" , onTextChange = {if(it.all { char->char.isLetter()||char.isWhitespace()})title = it}){}
            NotesInputText(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),text = description, label = "Add a note" , onTextChange = {if(it.all { char->char.isLetter()||char.isWhitespace()})description = it} ){}
            NoteButton(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),text = "Save",
                onClick = {
                    if(title.isNotEmpty() && description.isNotEmpty()){
                        onAddNote(Note(title = title, description = description))
                        title = ""
                        description = ""
                        Toast.makeText(context,"Note Added",Toast.LENGTH_SHORT).show()
                    }
                }
            )

        }
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
        LazyColumn {
            items(notes){note -> NoteRow(note = note, onNoteClicked = {
                onRemoveNote(note)
            })}
        }

    }
}


@Composable
fun NoteRow(modifier: Modifier = Modifier,note: Note,onNoteClicked:(Note)->Unit) {
    Surface(modifier = Modifier.padding(4.dp).fillMaxWidth().clip(RoundedCornerShape(topEnd = 18.dp, bottomStart = 18.dp)),color = Color(0xFFDFE6EB)) {
        Column(modifier = modifier.padding(horizontal = 14.dp, vertical = 6.dp).clickable{onNoteClicked(note)}, horizontalAlignment = Alignment.Start) {
            Text(text = note.title, style = MaterialTheme.typography.titleLarge)
            Text(text = note.description, style = MaterialTheme.typography.bodyMedium)
            Text(text = formatDate(note.entryDate.time), style = MaterialTheme.typography.bodySmall)
        }
        
    }
}

@Preview(showBackground = true)
@Composable
fun NotesScreenPreview() {
    NotesScreen(notes = NotesDataSource().loadNotes(),onAddNote = {},onRemoveNote = {})
}