package ak.www.kursakademiaandroida.features.episodes.navigation

import ak.www.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable

interface EpisodeNavigator {

    fun openEpisodeDetailsScreen(episode: EpisodeDisplayable)
    fun goBack()
}