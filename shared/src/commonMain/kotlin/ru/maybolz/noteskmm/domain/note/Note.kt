package ru.maybolz.noteskmm.domain.note

import kotlinx.datetime.LocalDateTime
import ru.maybolz.noteskmm.presentation.BabyBlueHex
import ru.maybolz.noteskmm.presentation.LightGreenHex
import ru.maybolz.noteskmm.presentation.RedOrangeHex
import ru.maybolz.noteskmm.presentation.RedPinkHex
import ru.maybolz.noteskmm.presentation.VioletHex

data class Note(
    val id: Long?,
    val title: String,
    val content: String,
    val colorHex: Long,
    val created: LocalDateTime,
) {
    companion object {
        private val colors = listOf(
            RedOrangeHex,
            RedPinkHex,
            BabyBlueHex,
            VioletHex,
            LightGreenHex,
        )

        fun generateRandomColor() = colors.random()
    }
}
