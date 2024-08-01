package com.example.notesapp.repository

import com.example.notesapp.data.NoteDatabaseDao
import com.example.notesapp.models.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {
    suspend fun addNote(note:Note) =
        noteDatabaseDao.insert(note = note)

    suspend fun updateNote(note:Note) =
        noteDatabaseDao.update(note = note)

    suspend fun deleteNote(note:Note)=
        noteDatabaseDao.deleteNote(note = note)

    suspend fun deleteAllNotes() =
        noteDatabaseDao.deleteAll()

    fun getAllNotes(): Flow<List<Note>> =
        noteDatabaseDao.getNotes().flowOn(Dispatchers.IO).conflate()


}