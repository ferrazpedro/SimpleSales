package com.eval.simplesales.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eval.simplesales.data.local.interfaces.SalesDAO
import com.eval.simplesales.data.local.models.Converters
import com.eval.simplesales.data.local.models.SalesBD

@Database(
    entities = [
        SalesBD::class],
    version = 0
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun salesDAO(): SalesDAO
}