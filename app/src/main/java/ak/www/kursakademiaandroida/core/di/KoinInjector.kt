package ak.www.kursakademiaandroida.core.di

import org.koin.core.module.Module

val koinInjector: List<Module> = featureModules
    .plus(networkModule)
    .plus(appModule)
    .plus(databaseModule)
