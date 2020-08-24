package ak.www.kursakademiaandroida.core.base

sealed class UIState {

    object Idle : UIState()
    object Pending : UIState()
}