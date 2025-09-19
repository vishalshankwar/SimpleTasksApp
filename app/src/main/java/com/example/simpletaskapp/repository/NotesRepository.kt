package com.example.simpletaskapp.repository

import androidx.lifecycle.LiveData
import com.example.simpletaskapp.database.Notes
import com.example.simpletaskapp.database.NotesDao


class NotesRepository(private val notesDao: NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>> {
        return notesDao.getAllNotes()
    }

    fun searchNotes(query: String): LiveData<List<Notes>> {
        return notesDao.searchNotes("%$query%")
    }

    suspend fun insertNote(note: Notes) {
        notesDao.insertNote(note)
    }

    suspend fun deleteNote(note: Notes) {
        notesDao.deleteNote(note)
    }

    suspend fun deleteAllNotes() {
        notesDao.deleteAllNotes()
    }

    suspend fun updateNote(note: Notes) {
        notesDao.updateNote(note)
    }


}
