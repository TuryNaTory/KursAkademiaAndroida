package ak.www.kursakademiaandroida.features.locations.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import androidx.lifecycle.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<LocationViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationViewModel by viewModel()

    override fun initViews() {
        super.initViews()
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {

        }
    }
}