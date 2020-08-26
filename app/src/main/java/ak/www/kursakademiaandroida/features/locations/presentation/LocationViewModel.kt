package ak.www.kursakademiaandroida.features.locations.presentation

import ak.www.kursakademiaandroida.core.base.BaseViewModel
import ak.www.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import ak.www.kursakademiaandroida.features.locations.domain.model.Location
import ak.www.kursakademiaandroida.features.locations.presentation.model.LocationDisplayable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope

class LocationViewModel(private val getLocationsUseCase: GetLocationsUseCase) : BaseViewModel() {

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
}