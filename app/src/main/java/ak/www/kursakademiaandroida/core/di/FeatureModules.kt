package ak.www.kursakademiaandroida.core.di

import ak.www.kursakademiaandroida.features.characters.di.characterModule
import ak.www.kursakademiaandroida.features.episodes.di.episodeModule
import ak.www.kursakademiaandroida.features.locations.di.locationModule

val featureModules = listOf(
    episodeModule,
    locationModule,
    characterModule
)