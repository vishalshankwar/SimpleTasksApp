package com.example.simpletaskapp.ui.editnotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simpletaskapp.database.Notes
import com.example.simpletaskapp.repository.NotesRepository

class EditNotesViewModelFactory(
    private val repository: NotesRepository,
    private val note: Notes?
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EditNotesViewModel::class.java)) {
            return EditNotesViewModel(repository,note) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

