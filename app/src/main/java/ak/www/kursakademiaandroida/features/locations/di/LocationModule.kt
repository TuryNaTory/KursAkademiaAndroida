package ak.www.kursakademiaandroida.features.locations.di

import ak.www.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import ak.www.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import ak.www.kursakademiaandroida.features.locations.domain.LocationRepository
import ak.www.kursakademiaandroida.features.locations.presentation.LocationAdapter
import ak.www.kursakademiaandroida.features.locations.presentation.LocationFragment
import ak.www.kursakademiaandroida.features.locations.presentation.LocationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationViewModel(get()) }
    factory { LocationFragment() }
    factory { LocationAdapter() }
}