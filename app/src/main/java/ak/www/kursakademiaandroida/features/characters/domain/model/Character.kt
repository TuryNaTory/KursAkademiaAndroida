package ak.www.kursakademiaandroida.features.characters.domain.model

import ak.www.kursakademiaandroida.features.data.remote.model.CharacterLocation
import ak.www.kursakademiaandroida.features.data.remote.model.CharacterOrigin

data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val characterOrigin: CharacterOrigin,
    val characterLocation: CharacterLocation,
    val image: String,
    val episode: List<String>,
    val url: String
)