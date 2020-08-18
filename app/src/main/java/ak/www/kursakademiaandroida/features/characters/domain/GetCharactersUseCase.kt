package ak.www.kursakademiaandroida.features.characters.domain

import ak.www.kursakademiaandroida.core.base.UseCase
import ak.www.kursakademiaandroida.features.characters.domain.model.Character

class GetCharactersUseCase(private val characterRepository: CharacterRepository) :
    UseCase<List<Character>, Unit>() {

    override suspend fun action(params: Unit) = characterRepository.getCharacters()
}
