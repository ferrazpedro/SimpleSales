@file:OptIn(ExperimentalSerializationApi::class)

package com.eval.simplesales.utils

import com.eval.simplesales.data.repositories.SaleRepositoryImpl
import com.eval.simplesales.domain.repository.SaleRepository
import com.eval.simplesales.domain.usecases.GetSalesUC
import com.eval.simplesales.domain.usecases.PostSaleUC
import com.eval.simplesales.ui.launcher.SimpleSalesLauncherViewModel
import com.eval.simplesales.ui.make_sale.SimpleSalesMakeSaleViewModel
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    factory<SaleRepository> { SaleRepositoryImpl() }
}

val domainModule = module {
    factory { PostSaleUC(get()) }
    factory { GetSalesUC(get()) }
}

val presentationModule = module {
    viewModel { SimpleSalesLauncherViewModel(get()) }
    viewModel { SimpleSalesMakeSaleViewModel(get(), get()) }
}

val simpleSalesModules = repositoryModule + domainModule + presentationModule