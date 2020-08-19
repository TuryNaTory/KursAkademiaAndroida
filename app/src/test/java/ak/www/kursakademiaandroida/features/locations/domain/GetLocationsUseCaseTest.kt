package ak.www.kursakademiaandroida.features.locations.domain

import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.GlobalScope
import org.junit.Test

internal class GetLocationsUseCaseTest {

    @Test
    fun `when use case is invoked than execute getLocations method from repository`() {
        //given
        val repository = mockk<LocationRepository>(relaxed = true)
        val useCase = GetLocationsUseCase(repository)

        //when
        useCase.invoke(
            params = Unit,
            scope = GlobalScope
        )

        //then
        coVerify { repository.getLocations() }
    }
}