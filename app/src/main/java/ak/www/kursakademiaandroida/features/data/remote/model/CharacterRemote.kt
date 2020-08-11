package ak.www.kursakademiaandroida.features.data.remote.model

import ak.www.kursakademiaandroida.features.characters.domain.model.Character
import com.google.gson.annotations.SerializedName


data class CharacterRemote(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("type") val type: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("origin") val characterOrigin: CharacterOrigin,
    @SerializedName("location") val characterLocation: CharacterLocation,
    @SerializedName("image") val image: String,
    @SerializedName("episode") val episode: List<String>,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String
) {
    fun toCharacter() = Character(
        id = id,
        name = name,
        status = status,
        species = species,
        type = type,
        gender = gender,
        characterOrigin = characterOrigin,
        characterLocation = characterLocation,
        image = image,
        episode = episode,
        url = url
    )
}

data class CharacterOrigin(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class CharacterLocation(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)