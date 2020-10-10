package ak.www.kursakademiaandroida.features.characters.navigation

import ak.www.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable

interface CharacterNavigator {

    fun openCharacterDetailsScreen(character: CharacterDisplayable)
    fun goBack()
}