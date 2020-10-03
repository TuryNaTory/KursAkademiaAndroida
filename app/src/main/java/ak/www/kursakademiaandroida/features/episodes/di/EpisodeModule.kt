package ak.www.kursakademiaandroida.features.episodes.di

import ak.www.kursakademiaandroida.features.episodes.all.presentation.EpisodeAdapter
import ak.www.kursakademiaandroida.features.episodes.all.presentation.EpisodesFragment
import ak.www.kursakademiaandroida.features.episodes.all.presentation.EpisodesViewModel
import ak.www.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import ak.www.kursakademiaandroida.features.episodes.details.presentation.EpisodeViewModel
import ak.www.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import ak.www.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import ak.www.kursakademiaandroida.features.episodes.navigation.EpisodeNavigator
import ak.www.kursakademiaandroida.features.episodes.navigation.EpisodeNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodesViewModel(get(), get(), get()) }
    viewModel { EpisodeViewModel() }
    factory { EpisodesFragment() }
    factory { EpisodeAdapter() }

    //navigation
    factory<EpisodeNavigator> { EpisodeNavigatorImpl(get()) }
}