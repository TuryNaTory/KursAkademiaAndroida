package ak.www.kursakademiaandroida.features.locations.all.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import ak.www.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.fragment_location.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationsFragment : BaseFragment<LocationsViewModel>(R.layout.fragment_location) {

    override val viewModel: LocationsViewModel by viewModel()
    private val adapter: LocationAdapter by inject()
    private val dividerItemDecoration: DividerItemDecoration by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeLocations()
    }

    override fun onIdleState() {
        super.onIdleState()
        showProgressBar(false)
    }

    override fun onPendingState() {
        super.onPendingState()
        showProgressBar(true)
    }

    private fun initRecycler() {
        adapter.onLocationClickListener = { viewModel.onLocationClick(it) }
        rvLocations.adapter = adapter
        rvLocations.addItemDecoration(dividerItemDecoration)
    }

    private fun observeLocations() {
        viewModel.locations.observe(this) {
            showLocations(it)
        }
    }

    private fun showLocations(locations: List<LocationDisplayable>) {
        adapter.setLocations(locations)
    }
}