package com.example.test2movie.view.home.popular.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "PopularMovie_TBL")
data class Popular (
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val title: String
    )