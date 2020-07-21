package ak.www.kursakademiaandroida.core.di

import ak.www.kursakademiaandroida.features.data.AppDatabase
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "appDatabase"
        )
            .build()
    }
}