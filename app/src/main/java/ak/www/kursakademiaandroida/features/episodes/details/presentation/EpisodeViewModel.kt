package ak.www.kursakademiaandroida.features.episodes.details.presentation

import ak.www.kursakademiaandroida.core.base.BaseViewModel
import ak.www.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class EpisodeViewModel : BaseViewModel() {

    private val _episode by lazy { MutableLiveData<EpisodeDisplayable>() }
    val episode: LiveData<EpisodeDisplayable> by lazy { _episode }

    fun onEpisodePassed(episode: EpisodeDisplayable) {
        _episode.value = episode
    }
}