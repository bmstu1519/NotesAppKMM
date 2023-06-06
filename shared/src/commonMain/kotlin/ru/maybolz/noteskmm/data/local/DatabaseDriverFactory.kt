package ru.maybolz.noteskmm.data.local

import com.squareup.sqldelight.db.SqlDriver

/**
 * expect определяет контракт API для общего код
 * чтобы использовать одну абстракция,на разных платформах (expect),
 * но подставлять разную реализацию (actual)
 * */
expect class DatabaseDriverFactory {
    fun createDriver(): SqlDriver
}