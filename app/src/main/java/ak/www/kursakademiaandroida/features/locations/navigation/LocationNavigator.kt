package ak.www.kursakademiaandroida.features.locations.navigation

import ak.www.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable

interface LocationNavigator {

    fun openLocationDetailsScreen(location: LocationDisplayable)
    fun goBack()
}