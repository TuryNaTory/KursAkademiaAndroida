package ak.www.kursakademiaandroida.features.characters.domain

import ak.www.kursakademiaandroida.features.characters.domain.model.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>
}