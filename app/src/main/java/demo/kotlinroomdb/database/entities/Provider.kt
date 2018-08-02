package demo.kotlinroomdb.database.entities

 
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by axier on 7/2/18.
 */

@Entity
class Provider constructor(uid: Int, name: String){

    @PrimaryKey
    var uid: Int = uid

    @ColumnInfo(name = "name")
    var name: String? = name
}
