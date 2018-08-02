package demo.kotlinroomdb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Repo(id: Int, val name: String, val url: String) {
    @PrimaryKey
    val id: Int

    init {
        this.id = id
    }
}