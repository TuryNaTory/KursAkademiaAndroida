package ak.www.kursakademiaandroida.features.episodes.data.local.model

import ak.www.kursakademiaandroida.features.episodes.domain.model.Episode
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EpisodeCached(
    @PrimaryKey
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) {
    constructor(episode: Episode) : this(
        episode.id,
        episode.name,
        episode.airDate,
        episode.code,
        episode.characters,
        episode.url
    )

    companion object

    fun toEpisode() = Episode(
        id = id,
        name = name,
        airDate = airDate,
        code = code,
        characters = characters,
        url = url
    )
}