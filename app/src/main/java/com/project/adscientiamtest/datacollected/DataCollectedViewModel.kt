package com.project.adscientiamtest.datacollected

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.project.adscientiamtest.App
import com.project.adscientiamtest.modele.Square
import com.project.adscientiamtest.repository.SquareRepository

class DataCollectedViewModel : ViewModel() {


    val squares : LiveData<List<Square>> = App.database.squareDao().getAllSquares()

    fun deleteAllDatas() {
        SquareRepository.delete()
    }

}