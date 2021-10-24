package com.project.adscientiamtest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.adscientiamtest.modele.Square

const val DATABASE_BAME = "adscientam_database"

@Database(entities = [Square::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun squareDao() : SquareDao
}
