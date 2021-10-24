package com.project.adscientiamtest.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.adscientiamtest.App
import com.project.adscientiamtest.modele.Square
import com.project.adscientiamtest.repository.SquareRepository
import timber.log.Timber

class MainActivityViewModel : ViewModel() {

    val square : LiveData<Square> = App.database.squareDao().getSquare()

    fun delete() {
        Timber.i("Deleting...")
        SquareRepository.delete()
    }

    fun insert(square: Square) {
        SquareRepository.insertSquare(square)
    }


}