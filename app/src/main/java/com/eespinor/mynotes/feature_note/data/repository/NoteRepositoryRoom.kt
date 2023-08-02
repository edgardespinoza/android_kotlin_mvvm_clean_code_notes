package com.eespinor.mynotes.feature_note.data.repository

import com.eespinor.mynotes.feature_note.data.data_source.NoteDao
import com.eespinor.mynotes.feature_note.domain.model.Note
import com.eespinor.mynotes.feature_note.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryRoom(
    private val dao: NoteDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getNotes()
    }

    override suspend fun getNoteId(id: Int): Note? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNode(note: Note) {
        dao.insertNote(note)
    }

    override suspend fun deleteNode(note: Note) {
        dao.deleteNote(note)
    }
}