package ak.www.kursakademiaandroida.features.locations.di

import ak.www.kursakademiaandroida.features.locations.all.presentation.LocationAdapter
import ak.www.kursakademiaandroida.features.locations.all.presentation.LocationsFragment
import ak.www.kursakademiaandroida.features.locations.all.presentation.LocationsViewModel
import ak.www.kursakademiaandroida.features.locations.data.repository.LocationRepositoryImpl
import ak.www.kursakademiaandroida.features.locations.details.presentation.LocationViewModel
import ak.www.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import ak.www.kursakademiaandroida.features.locations.domain.LocationRepository
import ak.www.kursakademiaandroida.features.locations.navigation.LocationNavigator
import ak.www.kursakademiaandroida.features.locations.navigation.LocationNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    //data
    factory<LocationRepository> { LocationRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetLocationsUseCase(get()) }

    //presentation
    viewModel { LocationsViewModel(get(), get(), get()) }
    viewModel { LocationViewModel() }
    factory { LocationsFragment() }
    factory { LocationAdapter() }

    //navigation
    factory<LocationNavigator> { LocationNavigatorImpl(get()) }
}