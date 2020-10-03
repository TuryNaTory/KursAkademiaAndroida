package ak.www.kursakademiaandroida.features.locations.details.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import ak.www.kursakademiaandroida.features.locations.all.presentation.model.LocationDisplayable
import kotlinx.android.synthetic.main.fragment_location_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocationDetailsFragment :
    BaseFragment<LocationViewModel>(R.layout.fragment_location_details) {
    override val viewModel: LocationViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        setUI(arguments?.getParcelable(LOCATION_DETAILS_KEY))
    }

    private fun setUI(location: LocationDisplayable?) {
        tvId.text = location?.id.toString()
        tvName.text = location?.name
        tvType.text = location?.type
        tvDimension.text = location?.dimension
    }

    companion object {
        const val LOCATION_DETAILS_KEY = "episodeDetailsKey"
    }
}