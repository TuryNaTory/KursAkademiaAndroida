package ak.www.kursakademiaandroida.features.locations.all.presentation

import ak.www.kursakademiaandroida.core.base.BaseViewModel
import ak.www.kursakademiaandroida.core.exception.ErrorMapper
import ak.www.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import ak.www.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import ak.www.kursakademiaandroida.features.locations.domain.model.Location
import ak.www.kursakademiaandroida.features.locations.navigation.LocationNavigator
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope

class LocationsViewModel(
    private val getLocationsUseCase: GetLocationsUseCase,
    private val locationNavigator: LocationNavigator,
    errorMapper: ErrorMapper
) : BaseViewModel(errorMapper) {

    private val _locations by lazy {
        MutableLiveData<List<Location>>()
            .also { getLocations(it) }
    }

    val locations: LiveData<List<LocationDisplayable>> by lazy {
        _locations.map { locations ->
            locations.map { LocationDisplayable(it) }
        }
    }

    private fun getLocations(locationLiveData: MutableLiveData<List<Location>>) {
        setPendingState()
        getLocationsUseCase.invoke(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { locationLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }

    fun onLocationClick(location: LocationDisplayable) {
        locationNavigator.openLocationDetailsScreen(location)
    }
}