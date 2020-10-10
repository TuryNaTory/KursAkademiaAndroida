package ak.www.kursakademiaandroida.features.episodes.all.presentation.model

import ak.www.kursakademiaandroida.features.episodes.domain.model.Episode
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EpisodeDisplayable(
    val id: Int,
    val name: String,
    val airDate: String,
    val code: String,
    val characters: List<String>,
    val url: String
) : Parcelable {
    constructor(episode: Episode) : this(
        id = episode.id,
        name = episode.name,
        airDate = episode.airDate,
        code = episode.code,
        characters = episode.characters,
        url = episode.url
    )

    companion object
}