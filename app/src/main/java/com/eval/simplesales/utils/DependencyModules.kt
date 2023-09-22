@file:OptIn(ExperimentalSerializationApi::class)

package com.eval.simplesales.utils

import com.eval.simplesales.data.repositories.SaleRepositoryImpl
import com.eval.simplesales.domain.repository.SaleRepository
import com.eval.simplesales.domain.usecases.GetSalesUC
import com.eval.simplesales.domain.usecases.GetTotalSalesValueUC
import com.eval.simplesales.domain.usecases.PostSaleUC
import com.eval.simplesales.ui.history.SimpleSalesHistoryViewModel
import com.eval.simplesales.ui.launcher.SimpleSalesLauncherViewModel
import com.eval.simplesales.ui.make_sale.SimpleSalesMakeSaleViewModel
import kotlinx.serialization.ExperimentalSerializationApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val repositoryModule = module {
    factoryOf<SaleRepository>(::SaleRepositoryImpl)
}

val domainModule = module {
    factoryOf(::PostSaleUC)
    factoryOf(::GetTotalSalesValueUC)
    factoryOf(::GetSalesUC)
}

val presentationModule = module {
    viewModelOf(::SimpleSalesLauncherViewModel)
    viewModelOf(::SimpleSalesMakeSaleViewModel)
    viewModelOf(::SimpleSalesHistoryViewModel)
}

val simpleSalesModules = repositoryModule + domainModule + presentationModule