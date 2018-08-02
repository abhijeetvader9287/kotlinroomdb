package demo.kotlinroomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import demo.kotlinroomdb.daos.RepoDao
import demo.kotlinroomdb.entities.Repo

@Database(entities = arrayOf(Repo::class), version = 1)
abstract class RepoDatabase : RoomDatabase() {
    abstract val repoDao: RepoDao

    companion object {
        private val DB_NAME = "repoDatabase.db"
        @Volatile
        private var instance: RepoDatabase? = null

        @Synchronized
        internal fun getInstance(context: Context): RepoDatabase? {
            if (instance == null) {
                instance = create(context)
            }
            return instance
        }

        private fun create(context: Context): RepoDatabase {
            return Room.databaseBuilder(
                    context,
                    RepoDatabase::class.java,
                    DB_NAME).build()
        }
    }
}