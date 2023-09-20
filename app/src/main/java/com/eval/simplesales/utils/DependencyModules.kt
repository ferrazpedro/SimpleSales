@file:OptIn(ExperimentalSerializationApi::class)

package com.eval.simplesales.utils

import com.eval.simplesales.data.repositories.SaleRepositoryImpl
import com.eval.simplesales.domain.repository.SaleRepository
import com.eval.simplesales.domain.usecases.GetSalesUC
import com.eval.simplesales.domain.usecases.PostSaleUC
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.dsl.module

val repositoryModule = module {
    factory<SaleRepository> { SaleRepositoryImpl() }
}

val domainModule = module {
    factory { PostSaleUC(get()) }
    factory { GetSalesUC(get()) }
}

val simpleSalesModules = repositoryModule + domainModule