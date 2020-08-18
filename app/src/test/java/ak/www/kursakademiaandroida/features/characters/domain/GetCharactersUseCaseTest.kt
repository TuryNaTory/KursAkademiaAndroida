package ak.www.kursakademiaandroida.features.characters.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test

internal class GetCharactersUseCaseTest {

    @Test
    fun `when use case is invoked than execute getCharacters method from repository`() {
        //given
        val repository = mockk<CharacterRepository>(relaxed = true)
        val useCase = GetCharactersUseCase(repository)

        //when
        useCase.invoke(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getCharacters() }
    }
}