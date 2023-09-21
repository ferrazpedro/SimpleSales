package com.eval.simplesales.utils

import androidx.room.Room
import com.eval.simplesales.App
import com.eval.simplesales.data.local.AppDatabase
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
val db = Room.databaseBuilder(
    App.instance,
    AppDatabase::class.java, "${App.appName}.db"
)
    .fallbackToDestructiveMigration() //Destrói toda a database se o schema do banco não estiver compatível -> drop table all
    .allowMainThreadQueries() //Queries na main thread
    .build()

const val zero = 0.0