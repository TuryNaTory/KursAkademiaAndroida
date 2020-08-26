package ak.www.kursakademiaandroida.features.characters.presentation

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import androidx.lifecycle.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()

    override fun initViews() {
        super.initViews()
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
    }

    override fun onPendingState() {
        super.onPendingState()
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {

        }
    }
}