package com.eespinor.mynotes.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.eespinor.mynotes.ui.theme.BabyBlue
import com.eespinor.mynotes.ui.theme.LightGreen
import com.eespinor.mynotes.ui.theme.RedOrange
import com.eespinor.mynotes.ui.theme.RedPink
import com.eespinor.mynotes.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content:String,
    val timestamp: Long,
    val color : Int,
    @PrimaryKey val id: Int?=null
){
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}

class InvalidNoteException (message: String) : Exception(message)
