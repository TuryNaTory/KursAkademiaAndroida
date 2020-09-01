package ak.www.kursakademiaandroida.features.characters.presentation

import ak.www.kursakademiaandroida.MainActivity
import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.base.BaseFragment
import ak.www.kursakademiaandroida.features.characters.presentation.model.CharacterDisplayable
import androidx.lifecycle.observe
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_character.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : BaseFragment<CharacterViewModel>(R.layout.fragment_character) {

    override val viewModel: CharacterViewModel by viewModel()
    private val layoutManager: RecyclerView.LayoutManager by inject()
    private val adapter: CharacterAdapter by inject()

    override fun initViews() {
        super.initViews()
        initRecycler()
    }

    override fun initObservers() {
        super.initObservers()
        observeCharacters()
    }

    override fun onIdleState() {
        super.onIdleState()
        showProgressBar(false)
    }

    override fun onPendingState() {
        super.onPendingState()
        showProgressBar(true)
    }

    private fun showProgressBar(enable: Boolean) {
        (activity as MainActivity).showProgressBar(enable)
    }


    private fun initRecycler() {
        rvCharacters.layoutManager = layoutManager
        rvCharacters.adapter = adapter
    }

    private fun observeCharacters() {
        viewModel.characters.observe(this) {
            setCharacters(it)
        }
    }

    private fun setCharacters(characters: List<CharacterDisplayable>) {
        adapter.setCharacters(characters)
    }
}