package ak.www.kursakademiaandroida.features.locations.data.repository

import ak.www.kursakademiaandroida.core.api.RickAndMortyApi
import ak.www.kursakademiaandroida.core.network.NetworkStateProvider
import ak.www.kursakademiaandroida.features.locations.data.local.LocationDao
import ak.www.kursakademiaandroida.features.locations.data.local.model.LocationCached
import ak.www.kursakademiaandroida.features.locations.domain.LocationRepository
import ak.www.kursakademiaandroida.features.locations.domain.model.Location

class LocationRepositoryImpl(
    private val api: RickAndMortyApi,
    private val locationDao: LocationDao,
    private val networkStateProvider: NetworkStateProvider
) : LocationRepository {

    override suspend fun getLocations(): List<Location> {
        return if (networkStateProvider.isNetworkAvailable()) {
            getLocationsFromRemote()
                .also { saveLocationsToLocal(it) }
        } else {
            getLocationsFromLocal()
        }
    }

    private suspend fun getLocationsFromRemote(): List<Location> {
        return api.getLocations()
            .results
            .map { it.toLocation() }
    }

    private suspend fun saveLocationsToLocal(locations: List<Location>) {
        locations.map { LocationCached(it) }
            .toTypedArray()
            .let { locationDao.saveLocations(*it) }
    }

    private suspend fun getLocationsFromLocal(): List<Location> {
        return locationDao.getLocations()
            .map { it.toLocation() }
    }
}