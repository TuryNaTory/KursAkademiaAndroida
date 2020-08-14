package ak.www.kursakademiaandroida.features.locations.domain

import ak.www.kursakademiaandroida.core.base.UseCase
import ak.www.kursakademiaandroida.features.locations.domain.model.Location

class GetLocationsUseCase(private val locationRepository: LocationRepository) :
    UseCase<List<Location>, Unit>() {

    override suspend fun action(params: Unit) = locationRepository.getLocations()
}
