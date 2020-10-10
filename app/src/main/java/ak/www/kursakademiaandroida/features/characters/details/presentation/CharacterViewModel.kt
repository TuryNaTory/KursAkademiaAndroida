package ak.www.kursakademiaandroida.features.characters.details.presentation

import ak.www.kursakademiaandroida.core.base.BaseViewModel
import ak.www.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CharacterViewModel : BaseViewModel() {

    private val _character by lazy { MutableLiveData<CharacterDisplayable>() }
    val character: LiveData<CharacterDisplayable> by lazy { _character }

    fun onCharacterPassed(character: CharacterDisplayable) {
        _character.value = character
    }
}