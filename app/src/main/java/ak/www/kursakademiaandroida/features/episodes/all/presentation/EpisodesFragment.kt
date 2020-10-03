package ak.www.kursakademiaandroida.features.episodes.all.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import ak.www.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.fragment_episode.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : BaseFragment<EpisodesViewModel>(R.layout.fragment_episode) {

    override val viewModel: EpisodesViewModel by viewModel()
    private val adapter: EpisodeAdapter by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeEpisodes()
    }

    override fun onIdleState() {
        super.onIdleState()
        showProgressBar(false)
    }

    override fun onPendingState() {
        super.onPendingState()
        showProgressBar(true)
    }

    private fun initRecycler() {
        adapter.onEpisodeClickListener = { viewModel.onEpisodeClick(it) }
        rvEpisodes.adapter = adapter
        rvEpisodes.addItemDecoration(dividerItemDecoration)
    }

    private fun observeEpisodes() {
        viewModel.episodes.observe(this) {
            showEpisodes(it)
        }
    }

    private fun showEpisodes(episodes: List<EpisodeDisplayable>) {
        adapter.setEpisodes(episodes)
    }
}