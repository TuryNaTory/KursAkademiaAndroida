package ak.www.kursakademiaandroida.features.episodes.domain

import ak.www.kursakademiaandroida.core.base.UseCase
import ak.www.kursakademiaandroida.features.episodes.domain.model.Episode

class GetEpisodesUseCase(private val episodeRepository: EpisodeRepository) :
    UseCase<List<Episode>, Unit>() {

    override suspend fun action(params: Unit) = episodeRepository.getEpisodes()
}
