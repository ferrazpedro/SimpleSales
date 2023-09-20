package com.eval.simplesales.data.local.interfaces

import androidx.room.Dao
import androidx.room.Query
import com.eval.simplesales.data.local.models.SalesBD
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@Dao
interface SalesDAO {
    @Query("SELECT * FROM sales")
    fun getAll(): List<SalesBD>
}