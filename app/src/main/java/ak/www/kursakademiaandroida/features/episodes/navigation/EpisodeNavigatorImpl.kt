package ak.www.kursakademiaandroida.features.episodes.navigation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.navigation.FragmentNavigator
import ak.www.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import ak.www.kursakademiaandroida.features.episodes.details.presentation.EpisodeDetailsFragment

class EpisodeNavigatorImpl(private val fragmentNavigator: FragmentNavigator) : EpisodeNavigator {

    override fun openEpisodeDetailsScreen(episode: EpisodeDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_episodes_screen_to_episode_details_screen,
            EpisodeDetailsFragment.EPISODE_DETAILS_KEY to episode
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}