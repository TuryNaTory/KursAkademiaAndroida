package ak.www.kursakademiaandroida.core.di

import ak.www.kursakademiaandroida.core.database.AppDatabase
import androidx.room.Room
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidApplication(),
            AppDatabase::class.java,
            "appDatabase"
        )
            .build()
    }

    single { get<AppDatabase>().episodeDao() }

    single { get<AppDatabase>().characterDao() }

    single { get<AppDatabase>().locationDao() }
}