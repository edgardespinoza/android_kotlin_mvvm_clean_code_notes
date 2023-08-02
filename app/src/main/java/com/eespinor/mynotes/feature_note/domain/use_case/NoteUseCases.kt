package com.eespinor.mynotes.feature_note.domain.use_case

data class NoteUseCases (
    val deleteNote: DeleteNote,
    val getNotes:GetNotes,
    val addNote: AddNote,
    val getNote: GetNote
)