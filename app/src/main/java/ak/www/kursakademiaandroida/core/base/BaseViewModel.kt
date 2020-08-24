package ak.www.kursakademiaandroida.core.base

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hadilq.liveevent.LiveEvent

open class BaseViewModel : ViewModel(), DefaultLifecycleObserver {

    private val _message: LiveEvent<String> by lazy { LiveEvent<String>() }
    val message: LiveData<String> by lazy { _message }

    private val _uiState: MutableLiveData<UIState> by lazy { MutableLiveData<UIState>(UIState.Idle) }
    val uiState: LiveData<UIState> by lazy { _uiState }

    protected fun showMessage(message: String) {
        _message.value = message
    }

    protected fun setIdleState() {
        _uiState.value = UIState.Idle
    }

    protected fun setPendingState() {
        _uiState.value = UIState.Pending
    }

    protected fun handleFailure(throwable: Throwable) {
        throwable.message
            ?.let { showMessage(it) }
    }
}