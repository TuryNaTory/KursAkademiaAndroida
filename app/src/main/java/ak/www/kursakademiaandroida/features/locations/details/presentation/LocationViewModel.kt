package ak.www.kursakademiaandroida.features.locations.details.presentation

import ak.www.kursakademiaandroida.core.base.BaseViewModel
import ak.www.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LocationViewModel : BaseViewModel() {

    private val _location by lazy { MutableLiveData<LocationDisplayable>() }
    val location: LiveData<LocationDisplayable> by lazy { _location }

    fun onLocationPassed(location: LocationDisplayable) {
        _location.value = location
    }
}