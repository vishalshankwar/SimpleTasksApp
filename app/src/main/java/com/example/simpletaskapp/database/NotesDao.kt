package com.example.simpletaskapp.database


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Notes)

    @Query("SELECT * FROM notes_table ORDER BY id DESC")
    fun getAllNotes(): LiveData<List<Notes>>

    @Query("SELECT * FROM notes_table WHERE id = :noteId LIMIT 1")
    fun getNoteById(noteId: Int): LiveData<Notes>

    @Query("SELECT * FROM notes_table WHERE title LIKE :query OR description LIKE :query ORDER BY id DESC")
    fun searchNotes(query: String): LiveData<List<Notes>>

    @Delete
    suspend fun deleteNote(note: Notes)

    @Query("DELETE FROM notes_table")
    suspend fun deleteAllNotes()

    @Update
    suspend fun updateNote(note: Notes)

    @Update
    suspend fun updateNoteColor(note: Notes)
}

