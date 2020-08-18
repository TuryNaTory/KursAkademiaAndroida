package ak.www.kursakademiaandroida.core.database

import ak.www.kursakademiaandroida.features.episodes.data.local.EpisodeDao
import ak.www.kursakademiaandroida.features.episodes.data.local.model.EpisodeCached
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [EpisodeCached::class], version = 1)
@TypeConverters(ListConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun episodeDao(): EpisodeDao
}