package ak.www.kursakademiaandroida.features.characters.di


import ak.www.kursakademiaandroida.features.characters.all.presentation.CharacterAdapter
import ak.www.kursakademiaandroida.features.characters.all.presentation.CharactersFragment
import ak.www.kursakademiaandroida.features.characters.all.presentation.CharactersViewModel
import ak.www.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import ak.www.kursakademiaandroida.features.characters.details.presentation.CharacterViewModel
import ak.www.kursakademiaandroida.features.characters.domain.CharacterRepository
import ak.www.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import ak.www.kursakademiaandroida.features.characters.navigation.CharacterNavigator
import ak.www.kursakademiaandroida.features.characters.navigation.CharacterNavigatorImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharactersViewModel(get(), get(), get()) }
    viewModel { CharacterViewModel() }
    factory { CharactersFragment() }
    factory { CharacterAdapter() }

    //navigation
    factory<CharacterNavigator> { CharacterNavigatorImpl(get()) }
}