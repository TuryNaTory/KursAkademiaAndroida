package ak.www.kursakademiaandroida.features.characters.presentation

import ak.www.kursakademiaandroida.core.base.BaseViewModel
import ak.www.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import ak.www.kursakademiaandroida.features.characters.domain.model.Character
import ak.www.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope

class CharacterViewModel(private val getCharactersUseCase: GetCharactersUseCase) : BaseViewModel() {

    private val _characters by lazy {
        MutableLiveData<List<Character>>()
            .also { getCharacters(it) }
    }

    val characters: LiveData<List<CharacterDisplayable>> by lazy {
        _characters.map { characters ->
            characters.map { CharacterDisplayable(it) }
        }
    }

    private fun getCharacters(characterLiveData: MutableLiveData<List<Character>>) {
        setPendingState()
        getCharactersUseCase.invoke(
            params = Unit,
            scope = viewModelScope
        ) { result ->
            setIdleState()
            result.onSuccess { characterLiveData.value = it }
            result.onFailure { handleFailure(it) }
        }
    }
}