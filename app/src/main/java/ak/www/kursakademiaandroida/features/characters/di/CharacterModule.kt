package ak.www.kursakademiaandroida.features.characters.di


import ak.www.kursakademiaandroida.features.characters.data.repository.CharacterRepositoryImpl
import ak.www.kursakademiaandroida.features.characters.domain.CharacterRepository
import ak.www.kursakademiaandroida.features.characters.domain.GetCharactersUseCase
import ak.www.kursakademiaandroida.features.characters.presentation.CharacterAdapter
import ak.www.kursakademiaandroida.features.characters.presentation.CharacterFragment
import ak.www.kursakademiaandroida.features.characters.presentation.CharacterViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val characterModule = module {
    //data
    factory<CharacterRepository> { CharacterRepositoryImpl(get(), get(), get()) }

    //domain
    factory { GetCharactersUseCase(get()) }

    //presentation
    viewModel { CharacterViewModel(get()) }
    factory { CharacterFragment() }
    factory { CharacterAdapter() }
}