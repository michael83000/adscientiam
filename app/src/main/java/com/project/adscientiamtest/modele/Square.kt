package com.project.adscientiamtest.modele

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Square(@PrimaryKey(autoGenerate = true) var id: Int,
                  var x : Float,
                  var y : Float,
                  var date: Long)