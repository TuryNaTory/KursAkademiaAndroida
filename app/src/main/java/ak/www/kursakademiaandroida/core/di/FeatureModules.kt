package ak.www.kursakademiaandroida.core.di

import ak.www.kursakademiaandroida.features.episodes.di.episodeModule
import org.koin.core.module.Module

val featureModules = listOf<Module>(
    episodeModule
)