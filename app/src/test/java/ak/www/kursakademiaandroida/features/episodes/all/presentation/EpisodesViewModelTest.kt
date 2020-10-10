package ak.www.kursakademiaandroida.features.episodes.all.presentation

import ak.www.kursakademiaandroida.core.base.UIState
import ak.www.kursakademiaandroida.core.exception.ErrorMapper
import ak.www.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import ak.www.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import ak.www.kursakademiaandroida.features.episodes.domain.model.Episode
import ak.www.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import ak.www.kursakademiaandroida.mock.mock
import ak.www.kursakademiaandroida.utils.ViewModelTest
import ak.www.kursakademiaandroida.utils.getOrAwaitValue
import ak.www.kursakademiaandroida.utils.observeForTesting
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class EpisodesViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN episode is clicked THEN open episode details screen`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)
        val episode = EpisodeDisplayable.mock()

        //when
        viewModel.onEpisodeClick(episode)

        //then
        verify { episodeNavigator.openEpisodeDetailsScreen(episode) }
    }

    @Test
    fun `WHEN episode live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Pending
    }

    @Test
    fun `WHEN episode live data is observed THEN invoke use case to get episodes`() {
        //given
        val useCase = mockk<GetEpisodesUseCase>(relaxed = true)
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case is success WHEN episode live data is observed THEN set idle state AND set result in live data`() {
        //given
        val episodes = listOf(Episode.mock(), Episode.mock(), Episode.mock())
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.success(episodes))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        //when
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        viewModel.episodes.getOrAwaitValue().forEachIndexed { index, episodeDisplayable ->
            val episode = episodes[index]
            episodeDisplayable.name shouldBe episode.name
            episodeDisplayable.airDate shouldBe episode.airDate
            episodeDisplayable.code shouldBe episode.code
        }
    }

    @Test
    fun `GIVEN use case is failure WHEN episode live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetEpisodesUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Episode>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val episodeNavigator = mockk<EpisodeNavigator>(relaxed = true)
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = EpisodesViewModel(useCase, episodeNavigator, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.episodes.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}