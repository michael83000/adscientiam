package com.project.adscientiamtest.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.project.adscientiamtest.modele.Square

@Dao
interface SquareDao {

    @Insert
    fun insertSquare(square: Square)

    @Query("SELECT * FROM square")
    fun getAllSquares() : LiveData<List<Square>>

    @Query("SELECT * FROM square ORDER BY id DESC LIMIT 1")
    fun getSquare() : LiveData<Square>


    @Query("DELETE FROM square")
    fun delete()



}
