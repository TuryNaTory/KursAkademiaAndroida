package ak.www.kursakademiaandroida.features.episodes.details.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import ak.www.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import android.os.Bundle
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.fragment_episode_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeDetailsFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodeViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        observeEpisode()
    }

    private fun observeEpisode() {
        viewModel.episode.observe(this) { showEpisode(it) }
    }

    private fun showEpisode(episode: EpisodeDisplayable) {
        tvId.text = episode.id.toString()
        tvAirDate.text = episode.airDate
        tvName.text = episode.name
        tvCode.text = episode.code
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<EpisodeDisplayable>(EPISODE_DETAILS_KEY)
            ?.let { viewModel.onEpisodePassed(it) }
    }

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }
}