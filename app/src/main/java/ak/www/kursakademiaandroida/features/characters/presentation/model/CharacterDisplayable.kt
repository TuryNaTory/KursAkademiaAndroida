package ak.www.kursakademiaandroida.features.characters.presentation.model

import ak.www.kursakademiaandroida.features.characters.domain.model.Character
import ak.www.kursakademiaandroida.features.data.remote.model.CharacterLocation
import ak.www.kursakademiaandroida.features.data.remote.model.CharacterOrigin

data class CharacterDisplayable(
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
) {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        characterOrigin = character.characterOrigin,
        characterLocation = character.characterLocation,
        image = character.image,
        episode = character.episode,
        url = character.url
    )
}
