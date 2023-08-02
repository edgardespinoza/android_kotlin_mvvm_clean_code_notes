package com.eespinor.mynotes.di

import android.app.Application
import androidx.room.Room
import com.eespinor.mynotes.feature_note.data.data_source.NoteDatabase
import com.eespinor.mynotes.feature_note.data.repository.NoteRepositoryRoom
import com.eespinor.mynotes.feature_note.domain.repository.NoteRepository
import com.eespinor.mynotes.feature_note.domain.use_case.AddNote
import com.eespinor.mynotes.feature_note.domain.use_case.DeleteNote
import com.eespinor.mynotes.feature_note.domain.use_case.GetNote
import com.eespinor.mynotes.feature_note.domain.use_case.GetNotes
import com.eespinor.mynotes.feature_note.domain.use_case.NoteUseCases
import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app:Application):NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db:NoteDatabase):NoteRepository{
        return NoteRepositoryRoom(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCase(repository: NoteRepository):NoteUseCases{
        return NoteUseCases(
            deleteNote = DeleteNote(repository),
            getNotes = GetNotes(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }

}
