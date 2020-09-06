package ak.www.kursakademiaandroida.features.characters.presentation

import ak.www.kursakademiaandroida.core.base.UIState
import ak.www.kursakademiaandroida.core.exception.ErrorMapper
import ak.www.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import ak.www.kursakademiaandroida.features.characters.domain.model.Character
import ak.www.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable
import ak.www.kursakademiaandroida.mock.mock
import ak.www.kursakademiaandroida.utils.ViewModelTest
import ak.www.kursakademiaandroida.utils.getOrAwaitValue
import ak.www.kursakademiaandroida.utils.observeForTesting
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class CharacterViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN character live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Pending
    }

    @Test
    fun `WHEN character live data is observed THEN invoke use case to get characters`() {
        //given
        val useCase = mockk<GetCharactersUseCase>(relaxed = true)
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case is success WHEN character live data is observed THEN set idle state AND set result in live data`() {
        //given
        val characters = listOf(Character.mock(), Character.mock(), Character.mock())
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.success(characters))
            }
        }
        val errorMapper = mockk<ErrorMapper>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, errorMapper)

        //when
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        viewModel.characters.getOrAwaitValue().forEachIndexed { index, characterDisplayable ->
            val character = characters[index]
            characterDisplayable.name shouldBe character.name
            characterDisplayable.characterLocation.name shouldBe CharacterDisplayable.CharacterLocationDisplayable(
                character.characterLocation
            ).name
            characterDisplayable.characterLocation.url shouldBe CharacterDisplayable.CharacterLocationDisplayable(
                character.characterLocation
            ).url
            characterDisplayable.characterOrigin.name shouldBe CharacterDisplayable.CharacterOriginDisplayable(
                character.characterOrigin
            ).name
            characterDisplayable.characterOrigin.url shouldBe CharacterDisplayable.CharacterOriginDisplayable(
                character.characterOrigin
            ).url
            characterDisplayable.episode shouldBe character.episode
            characterDisplayable.gender shouldBe character.gender
            characterDisplayable.id shouldBe character.id
        }
    }

    @Test
    fun `GIVEN use case is failure WHEN character live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetCharactersUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Character>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val errorMapper = mockk<ErrorMapper> {
            every { map(any()) } returns throwable.message!!
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = CharacterViewModel(useCase, errorMapper)

        //when
        viewModel.message.observeForever(observer)
        viewModel.characters.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}