package ak.www.kursakademiaandroida.features.episodes.all.presentation

import ak.www.kursakademiaandroida.core.base.BaseViewModel
import ak.www.kursakademiaandroida.core.exception.ErrorMapper
import ak.www.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import ak.www.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import ak.www.kursakademiaandroida.features.episodes.domain.model.Episode
import ak.www.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope

class EpisodesViewModel(
    private val getEpisodesUseCase: GetEpisodesUseCase,
    private val episodeNavigator: EpisodeNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _episodes by lazy {
        MutableLiveData<List<Episode>>()
            .also { getEpisodes(it) }
    }

    val episodes: LiveData<List<EpisodeDisplayable>> by lazy {
        _episodes.map { episodes ->
            episodes.map { EpisodeDisplayable(it) }
        }
    }

    private fun getEpisodes(episodeLiveData: MutableLiveData<List<Episode>>) {
        setPendingState()
        getEpisodesUseCase.invoke(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { episodeLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onEpisodeClick(episode: EpisodeDisplayable) {
        episodeNavigator.openEpisodeDetailsScreen(episode)
    }
}