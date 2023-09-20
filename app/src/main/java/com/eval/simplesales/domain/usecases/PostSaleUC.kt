package com.eval.simplesales.domain.usecases

import com.eval.simplesales.domain.models.Sale
import com.eval.simplesales.domain.repository.SaleRepository

class PostSaleUC(private val repo: SaleRepository) {

    suspend fun execute(sale: Sale) {
        try {
            repo.insertSale(sale)
        } catch (t: Throwable) {
            throw t
        }
    }
}