package demo.kotlinroomdb.database.daos


import androidx.room.*
import demo.kotlinroomdb.entities.Repo

@Dao
interface RepoDao {
    @get:Query("SELECT * FROM repo")
    val allRepos: List<Repo>

    @Insert
    fun insert(vararg repos: Repo)

    @Update
    fun update(vararg repos: Repo)

    @Delete
    fun delete(vararg repos: Repo)
}