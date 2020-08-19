package ak.www.kursakademiaandroida.features.episodes.domain

import ak.www.kursakademiaandroida.features.episodes.domain.model.Episode

interface EpisodeRepository {
    suspend fun getEpisodes(): List<Episode>
}