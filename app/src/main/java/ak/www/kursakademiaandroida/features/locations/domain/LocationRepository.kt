package ak.www.kursakademiaandroida.features.locations.domain

import ak.www.kursakademiaandroida.features.locations.domain.model.Location

interface LocationRepository {
    suspend fun getLocations(): List<Location>
}