package com.project.adscientiamtest.repository

import com.project.adscientiamtest.App
import com.project.adscientiamtest.modele.Square
import timber.log.Timber
import java.util.concurrent.Executors

object SquareRepository {

        fun insertSquare(square: Square) {
            Executors.newSingleThreadExecutor().execute {
                App.database.squareDao().insertSquare(square)
            }
        }

        fun delete() {
            Executors.newSingleThreadExecutor().execute {
                Timber.i("Deleted")
                App.database.squareDao().delete()
            }
        }

}