package ak.www.kursakademiaandroida.features.episodes.details.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import ak.www.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import kotlinx.android.synthetic.main.fragment_episode_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class EpisodeDetailsFragment : BaseFragment<EpisodeViewModel>(R.layout.fragment_episode_details) {

    override val viewModel: EpisodeViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        setUI(arguments?.getParcelable(EPISODE_DETAILS_KEY))
    }

    private fun setUI(episode: EpisodeDisplayable?) {
        tvId.text = episode?.id.toString()
        tvAirDate.text = episode?.airDate
        tvName.text = episode?.name
        tvCode.text = episode?.code
    }

    companion object {
        const val EPISODE_DETAILS_KEY = "episodeDetailsKey"
    }
}