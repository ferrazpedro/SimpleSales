package com.eval.simplesales.data.local.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eval.simplesales.data.local.Entities.SaleEntity
import com.eval.simplesales.domain.models.Sale
import kotlinx.serialization.ExperimentalSerializationApi

@ExperimentalSerializationApi
@Dao
interface SaleDAO {
    @Query("SELECT * FROM sales")
    fun getAll(): List<SaleEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSale(sale: Sale)
}