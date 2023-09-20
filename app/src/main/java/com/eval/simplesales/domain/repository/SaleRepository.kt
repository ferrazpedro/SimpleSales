package com.eval.simplesales.domain.repository

import com.eval.simplesales.domain.models.Sale

interface SaleRepository {
    suspend fun getSales(): ArrayList<Sale?>
    suspend fun insertSale(sale: Sale)
}