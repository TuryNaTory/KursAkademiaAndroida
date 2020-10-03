package ak.www.kursakademiaandroida.features.characters.details.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import ak.www.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import kotlinx.android.synthetic.main.fragment_character_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterDetailsFragment :
    BaseFragment<CharacterViewModel>(R.layout.fragment_character_details) {
    override val viewModel: CharacterViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        setUI(arguments?.getParcelable(CHARACTER_DETAILS_KEY))
    }

    private fun setUI(character: CharacterDisplayable?) {
        tvId.text = character?.id.toString()
        tvName.text = character?.name
        tvStatus.text = character?.status
        tvSpecies.text = character?.species
        tvType.text = character?.type
        tvGender.text = character?.gender
    }

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

}