package ak.www.kursakademiaandroida.features.episodes.di

import ak.www.kursakademiaandroida.features.episodes.data.repository.EpisodeRepositoryImpl
import ak.www.kursakademiaandroida.features.episodes.domain.EpisodeRepository
import ak.www.kursakademiaandroida.features.episodes.domain.GetEpisodesUseCase
import ak.www.kursakademiaandroida.features.episodes.presentation.EpisodeAdapter
import ak.www.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import ak.www.kursakademiaandroida.features.episodes.presentation.EpisodeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val episodeModule = module {
    //data
    factory<EpisodeRepository> { EpisodeRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetEpisodesUseCase(get()) }

    //presentation
    viewModel { EpisodeViewModel(get()) }
    factory { EpisodeFragment() }
    factory { EpisodeAdapter() }
}