package com.eval.simplesales.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eval.simplesales.data.local.Entities.SaleEntity
import com.eval.simplesales.data.local.interfaces.SaleDAO
import com.eval.simplesales.data.mappers.Converters
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@Database(
    entities = [
        SaleEntity::class],
    version = 0
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun salesDAO(): SaleDAO
}