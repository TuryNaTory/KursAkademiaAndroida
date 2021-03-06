package ak.www.kursakademiaandroida.features.characters.all.presentation.model

import ak.www.kursakademiaandroida.features.characters.domain.model.Character
import ak.www.kursakademiaandroida.features.characters.domain.model.CharacterLocation
import ak.www.kursakademiaandroida.features.characters.domain.model.CharacterOrigin
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterDisplayable(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val characterOrigin: CharacterOriginDisplayable,
    val characterLocation: CharacterLocationDisplayable,
    val image: String,
    val episode: List<String>,
    val url: String
) : Parcelable {
    constructor(character: Character) : this(
        id = character.id,
        name = character.name,
        status = character.status,
        species = character.species,
        type = character.type,
        gender = character.gender,
        characterOrigin = CharacterOriginDisplayable(character.characterOrigin),
        characterLocation = CharacterLocationDisplayable(character.characterLocation),
        image = character.image,
        episode = character.episode,
        url = character.url
    )

    @Parcelize
    data class CharacterOriginDisplayable(
        val name: String,
        val url: String
    ) : Parcelable {
        constructor(characterOrigin: CharacterOrigin) : this(
            name = characterOrigin.name,
            url = characterOrigin.url
        )

        companion object
    }

    @Parcelize
    data class CharacterLocationDisplayable(
        val name: String,
        val url: String
    ) : Parcelable {
        constructor(characterLocation: CharacterLocation) : this(
            name = characterLocation.name,
            url = characterLocation.url
        )

        companion object
    }

    companion object
}
