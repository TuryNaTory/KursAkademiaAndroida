package ak.www.kursakademiaandroida.features.episodes.data.repository

import ak.www.kursakademiaandroida.core.api.RickAndMortyApi
import ak.www.kursakademiaandroida.core.exception.ErrorWrapper
import ak.www.kursakademiaandroida.core.exception.callOrThrow
import ak.www.kursakademiaandroida.core.network.NetworkStateProvider
import ak.www.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import ak.www.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import ak.www.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import ak.www.kursakademiaandroida.features.episodes.domain.model.Episode

class EpisodeRepositoryImpl(
    private val api: RickAndMortyApi,
    private val episodeDao: EpisodeDao,
    private val networkStateProvider: NetworkStateProvider,
    private val errorWrapper: ErrorWrapper
) : EpisodeRepository {

    override suspend fun getEpisodes(): List<Episode> {
        return if (networkStateProvider.isNetworkAvailable()) {
            callOrThrow(errorWrapper) { getEpisodesFromRemote() }
                .also { saveEpisodesToLocal(it) }
        } else {
            getEpisodesFromLocal()
        }
    }

    private suspend fun getEpisodesFromRemote(): List<Episode> {
        return api.getEpisodes()
            .results
            .map { it.toEpisode() }
    }

    private suspend fun saveEpisodesToLocal(episodes: List<Episode>) {
        episodes.map { EpisodeCached(it) }
            .toTypedArray()
            .let { episodeDao.saveEpisodes(*it) }
    }

    private suspend fun getEpisodesFromLocal(): List<Episode> {
        return episodeDao.getEpisodes()
            .map { it.toEpisode() }
    }
}