package ak.www.kursakademiaandroida.features.locations.presentation

import ak.www.kursakademiaandroida.core.base.UIState
import ak.www.kursakademiaandroida.features.locations.domain.GetLocationsUseCase
import ak.www.kursakademiaandroida.features.locations.domain.model.Location
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

internal class LocationViewModelTest : ViewModelTest() {

    @Test
    fun `WHEN location live data is observed THEN set pending state`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Pending
    }

    @Test
    fun `WHEN location live data is observed THEN invoke use case to get locations`() {
        //given
        val useCase = mockk<GetLocationsUseCase>(relaxed = true)
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.locations.observeForTesting()

        //then
        verify { useCase(Unit, viewModel.viewModelScope, any(), any()) }
    }

    @Test
    fun `GIVEN use case is success WHEN location live data is observed THEN set idle state AND set result in live data`() {
        //given
        val locations = listOf(Location.mock(), Location.mock(), Location.mock())
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.success(locations))
            }
        }
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        viewModel.locations.getOrAwaitValue().forEachIndexed { index, locationDisplayable ->
            val location = locations[index]
            locationDisplayable.name shouldBe location.name
            locationDisplayable.dimension shouldBe location.dimension
            locationDisplayable.id shouldBe location.id
            locationDisplayable.residents shouldBe location.residents
            locationDisplayable.type shouldBe location.type
            locationDisplayable.url shouldBe location.url
        }
    }

    @Test
    fun `GIVEN use case is failure WHEN location live data is observed THEN set idle state AND set error message in live data`() {
        //given
        val throwable = Throwable("Ops... Something went wrong")
        val useCase = mockk<GetLocationsUseCase> {
            every { this@mockk(any(), any(), any(), any()) } answers {
                lastArg<(Result<List<Location>>) -> Unit>()(Result.failure(throwable))
            }
        }
        val observer = mockk<Observer<String>>(relaxed = true)
        val viewModel = LocationViewModel(useCase)

        //when
        viewModel.message.observeForever(observer)
        viewModel.locations.observeForTesting()

        //then
        viewModel.uiState.getOrAwaitValue() shouldBe UIState.Idle
        verify { observer.onChanged(throwable.message) }
    }
}