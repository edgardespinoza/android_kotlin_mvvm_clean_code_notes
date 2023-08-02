package com.eespinor.mynotes.feature_note.domain.repository

import com.eespinor.mynotes.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    fun getNotes():Flow<List<Note>>

    suspend fun getNoteId(id: Int): Note?

    suspend fun insertNode(note:Note)

    suspend fun deleteNode(note:Note)
}