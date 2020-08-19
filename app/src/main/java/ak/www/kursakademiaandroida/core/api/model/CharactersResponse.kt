package ak.www.kursakademiaandroida.core.api.model

import ak.www.kursakademiaandroida.features.data.remote.model.CharacterRemote
import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("info") val info: ResponseInfo,
    @SerializedName("results") val results: List<CharacterRemote>
) {
    companion object
}