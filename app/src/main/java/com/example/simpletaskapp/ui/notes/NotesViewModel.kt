package com.example.simpletaskapp.ui.notes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpletaskapp.database.Notes
import com.example.simpletaskapp.repository.NotesRepository
import kotlinx.coroutines.launch


class NotesViewModel(private val repository: NotesRepository) :
    ViewModel() {

    val allNotes: LiveData<List<Notes>> = repository.getAllNotes()

    private val _navigateToSelectedNote = MutableLiveData<Notes?>()
    val navigateToSelectedNote: LiveData<Notes?>
        get() = _navigateToSelectedNote

    fun onNoteClicked(note: Notes) {
        _navigateToSelectedNote.value = note
    }

    fun displayPropertyDetailsComplete() {
        _navigateToSelectedNote.value = null
    }

    fun deleteALlNotes() {
        viewModelScope.launch {
            repository.deleteAllNotes()
        }
    }

    fun searchNotes(query: String): LiveData<List<Notes>> {
        return repository.searchNotes(query)
    }
}

