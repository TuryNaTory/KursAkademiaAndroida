package ak.www.kursakademiaandroida.core.di

val koinInjector = featureModules
    .plus(appModule)
    .plus(networkModule)
    .plus(databaseModule)
