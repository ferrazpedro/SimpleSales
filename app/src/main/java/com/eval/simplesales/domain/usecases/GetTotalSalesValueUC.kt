package com.eval.simplesales.domain.usecases

import com.eval.simplesales.domain.repository.SaleRepository
import com.eval.simplesales.utils.zeroDouble

class GetTotalSalesValueUC(private val repo: SaleRepository) {

    suspend fun execute(): Double {
        var value = zeroDouble

        return try {
            val list = repo.getSales()
            for (sale in list) {
                sale?.totalPrice?.let { value += it }
            }
            value
        } catch (t: Throwable) {
            value
        }
    }
}