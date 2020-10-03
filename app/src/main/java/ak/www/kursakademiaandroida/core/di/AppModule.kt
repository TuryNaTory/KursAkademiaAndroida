package ak.www.kursakademiaandroida.core.di

import ak.www.kursakademiaandroida.R
import ak.www.kursakademiaandroida.core.exception.ErrorMapper
import ak.www.kursakademiaandroida.core.exception.ErrorMapperImpl
import ak.www.kursakademiaandroida.core.exception.ErrorWrapper
import ak.www.kursakademiaandroida.core.exception.ErrorWrapperImpl
import ak.www.kursakademiaandroida.core.navigation.FragmentNavigator
import ak.www.kursakademiaandroida.core.navigation.FragmentNavigatorImpl
import ak.www.kursakademiaandroida.core.network.NetworkStateProvider
import ak.www.kursakademiaandroida.core.network.NetworkStateProviderImpl
import ak.www.kursakademiaandroida.core.provider.ActivityProvider
import android.content.Context
import android.net.ConnectivityManager
import androidx.navigation.navOptions
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    factory { LinearLayoutManager(androidContext()) }
    factory<RecyclerView.LayoutManager> { GridLayoutManager(androidContext(), 2) }
    factory { DividerItemDecoration(androidContext(), LinearLayoutManager.VERTICAL) }
    factory { androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager }
    factory<NetworkStateProvider> { NetworkStateProviderImpl(get()) }
    factory<ErrorWrapper> { ErrorWrapperImpl() }
    factory<ErrorMapper> { ErrorMapperImpl(androidContext()) }
    single(createdAtStart = true) { ActivityProvider(androidApplication()) }
    factory<FragmentNavigator> {
        FragmentNavigatorImpl(
            activityProvider = get(),
            navHostFragmentRes = R.id.nav_host_fragment,
            homeDestinationRes = R.id.characters_screen,
            defaultNavOptions = get()
        )
    }
    factory {
        navOptions {
            anim { enter = R.anim.fragment_fade_enter }
            anim { exit = R.anim.fragment_fade_exit }
            anim { popEnter = R.anim.fragment_close_enter }
            anim { popExit = R.anim.fragment_close_exit }
        }
    }
}