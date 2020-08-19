package ak.www.kursakademiaandroida.core.database

import ak.www.kursakademiaandroida.features.characters.data.local.CharacterDao
import ak.www.kursakademiaandroida.features.characters.data.local.model.CharacterCached
import ak.www.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import ak.www.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import ak.www.kursakademiaandroida.features.locations.data.local.LocationDao
import ak.www.kursakademiaandroida.features.locations.data.local.model.LocationCached
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [EpisodeCached::class, CharacterCached::class, LocationCached::class],
    version = 1
)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao

    abstract fun characterDao(): CharacterDao

    abstract fun locationsDao(): LocationDao
}