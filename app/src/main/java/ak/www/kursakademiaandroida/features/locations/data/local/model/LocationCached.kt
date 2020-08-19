package ak.www.kursakademiaandroida.features.locations.data.local.model

import ak.www.kursakademiaandroida.features.locations.domain.model.Location
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LocationCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String
) {
    constructor(location: Location) : this(
        location.id,
        location.name,
        location.type,
        location.dimension,
        location.residents,
        location.url
    )

    companion object

    fun toLocation() = Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension,
        residents = residents,
        url = url
    )
}