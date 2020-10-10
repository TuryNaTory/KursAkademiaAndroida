package ak.www.kursakademiaandroida.features.characters.details.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import ak.www.kursakademiaandroida.features.characters.all.presentation.model.CharacterDisplayable
import android.os.Bundle
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.fragment_character_details.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class CharacterDetailsFragment :
    BaseFragment<CharacterViewModel>(R.layout.fragment_character_details) {
    override val viewModel: CharacterViewModel by viewModel()

    override fun initViews() {
        super.initViews()
        observeCharacter()
    }

    private fun observeCharacter() {
        viewModel.character.observe(this) { showCharacter(it) }
    }

    private fun showCharacter(character: CharacterDisplayable) {
        tvId.text = character.id.toString()
        tvName.text = character.name
        tvStatus.text = character.status
        tvSpecies.text = character.species
        tvType.text = character.type
        tvGender.text = character.gender
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notifyAboutData()
    }

    private fun notifyAboutData() {
        arguments
            ?.getParcelable<CharacterDisplayable>(CHARACTER_DETAILS_KEY)
            ?.let { viewModel.onCharacterPassed(it) }
    }

    companion object {
        const val CHARACTER_DETAILS_KEY = "characterDetailsKey"
    }

}