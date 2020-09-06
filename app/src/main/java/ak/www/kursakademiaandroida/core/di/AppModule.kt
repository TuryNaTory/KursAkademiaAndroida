package ak.www.kursakademiaandroida.core.di

import ak.www.kursakademiaandroida.core.exception.ErrorMapper
import ak.www.kursakademiaandroida.core.exception.ErrorMapperImpl
import ak.www.kursakademiaandroida.core.exception.ErrorWrapper
import ak.www.kursakademiaandroida.core.exception.ErrorWrapperImpl
import ak.www.kursakademiaandroida.core.network.NetworkStateProvider
import ak.www.kursakademiaandroida.core.network.NetworkStateProviderImpl
import android.content.Context
import android.net.ConnectivityManager
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
}