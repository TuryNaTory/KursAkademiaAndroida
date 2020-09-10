package ak.www.kursakademiaandroida.core.base

import ak.www.kursakademiaandroida.MainActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe

abstract class BaseFragment<T : BaseViewModel>(@LayoutRes layoutRes: Int) : Fragment(layoutRes) {

    abstract val viewModel: T

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        initObservers()
        bindViewModelToLifecycle()
    }

    open fun initViews() {}

    open fun initObservers() {
        observeMessage()
        observeUiState()
    }

    open fun onIdleState() {}

    open fun onPendingState() {}

    protected fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    protected fun showToast(@StringRes stringRes: Int) {
        showToast(getString(stringRes))
    }

    protected fun showProgressBar(enable: Boolean) {
        (activity as MainActivity).showProgressBar(enable)
    }

    private fun bindViewModelToLifecycle() {
        lifecycle.addObserver(viewModel)
    }

    private fun observeMessage() {
        viewModel.message.observe(viewLifecycleOwner) {
            showToast(it)
        }
    }

    private fun observeUiState() {
        viewModel.uiState.observe(viewLifecycleOwner) {
            when (it) {
                UIState.Idle -> onIdleState()
                UIState.Pending -> onPendingState()
            }
        }
    }
}