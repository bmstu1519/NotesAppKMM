package ru.maybolz.noteskmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform