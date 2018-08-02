package demo.kotlinroomdb.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import demo.kotlinroomdb.database.entities.Provider

/**
 * Created by axier on 7/2/18.
 */

@Dao
interface ProviderDao {

    @get:Query("SELECT * FROM provider")
    val all: List<Provider>

    @Query("SELECT * FROM provider WHERE uid IN (:providerIds)")
    fun loadAllByIds(providerIds: IntArray): List<Provider>

    @Query("SELECT * FROM provider WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Provider

    @Insert
    fun insertAll(providers: List<Provider>)

    @Delete
    fun delete(provider: Provider)

}
