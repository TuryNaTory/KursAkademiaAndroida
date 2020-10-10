package ak.www.kursakademiaandroida.features.locations.navigation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.navigation.FragmentNavigator
import ak.www.kursakademiaandroida.features.episodes.all.presentation.model.EpisodeDisplayable
import ak.www.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import ak.www.kursakademiaandroida.mock.mock
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.amshove.kluent.shouldBe
import org.junit.jupiter.api.Test

internal class LocationNavigatorImplTest {

    @Test
    fun `WHEN openLocationDetailsScreen is called THEN invoke navigateTo method of FragmentNavigator with appropriate action and location model as arguments`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)
        val location = LocationDisplayable.mock()
        val slot = slot<Pair<String, EpisodeDisplayable>>()

        //when
        locationNavigator.openLocationDetailsScreen(location)

        //then
        verify {
            fragmentNavigator.navigateTo(
                R.id.action_navigate_from_locations_screen_to_location_details_screen,
                capture(slot)
            )
        }
        slot.captured.second shouldBe location
    }

    @Test
    fun `WHEN goBack is called THEN invoke goBack method of FragmentNavigator`() {
        //given
        val fragmentNavigator = mockk<FragmentNavigator>(relaxed = true)
        val locationNavigator: LocationNavigator = LocationNavigatorImpl(fragmentNavigator)

        //when
        locationNavigator.goBack()

        //then
        verify {
            fragmentNavigator.goBack()
        }
    }
}