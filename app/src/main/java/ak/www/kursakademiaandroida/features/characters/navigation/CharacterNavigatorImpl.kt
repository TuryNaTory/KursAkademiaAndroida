package ak.www.kursakademiaandroida.features.characters.navigation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.navigation.FragmentNavigator
import ak.www.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import ak.www.kursakademiaandroida.features.characters.details.presentation.CharacterDetailsFragment

class CharacterNavigatorImpl(private val fragmentNavigator: FragmentNavigator) :
    CharacterNavigator {

    override fun openCharacterDetailsScreen(character: CharacterDisplayable) {
        fragmentNavigator.navigateTo(
            R.id.action_navigate_from_characters_screen_to_character_details_screen,
            CharacterDetailsFragment.CHARACTER_DETAILS_KEY to character
        )
    }

    override fun goBack() {
        fragmentNavigator.goBack()
    }
}