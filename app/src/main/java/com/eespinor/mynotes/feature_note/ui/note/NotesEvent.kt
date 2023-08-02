package com.eespinor.mynotes.feature_note.ui.note

import com.eespinor.mynotes.feature_note.domain.model.Note
import com.eespinor.mynotes.feature_note.domain.util.NoteOrder

sealed class NotesEvent{
    data class Order(val noteOrder:NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    object RestoreNote: NotesEvent()
    object ToggleOrderSection: NotesEvent()
}
