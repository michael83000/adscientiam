package com.project.adscientiamtest

import android.app.Application
import androidx.room.Room
import com.project.adscientiamtest.database.AppDatabase
import com.project.adscientiamtest.database.DATABASE_BAME
import timber.log.Timber

class App : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        database = Room.databaseBuilder(this, AppDatabase::class.java, DATABASE_BAME).build()
    }
}