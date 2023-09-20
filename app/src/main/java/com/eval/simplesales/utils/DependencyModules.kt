package com.eval.simplesales.utils

import com.eval.simplesales.domain.usecases.PostMakeSaleUC
import org.koin.dsl.module

val domainModule = module {
    factory { PostMakeSaleUC() }
}

val simpleSalesModules = domainModule