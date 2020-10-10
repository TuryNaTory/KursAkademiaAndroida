package ak.www.kursakademiaandroida.features.locations.details.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import ak.www.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import android.os.Bundle
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.fragment_location_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationDetailsFragment :
    BaseFragment<LocationViewModel>(R.layout.fragment_location_details) {
    override val viewModel: LocationViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        observeLocation()
    }

    private fun observeLocation() {
        viewModel.location.observe(this) { showLocation(it) }
    }

    private fun showLocation(location: LocationDisplayable?) {
        tvId.text = location?.id.toString()
        tvName.text = location?.name
        tvType.text = location?.type
        tvDimension.text = location?.dimension
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<LocationDisplayable>(LOCATION_DETAILS_KEY)
            ?.let { viewModel.onLocationPassed(it) }
    }

    companion object {
        const val LOCATION_DETAILS_KEY = "episodeDetailsKey"
    }
}