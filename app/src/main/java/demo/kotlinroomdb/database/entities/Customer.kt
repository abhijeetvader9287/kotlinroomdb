package demo.kotlinroomdb.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by axier on 7/2/18.
 */

@Entity
class Customer constructor(uid: Int, firstName: String, lastName: String) {

    @PrimaryKey
    var uid: Int = uid

    @ColumnInfo(name = "first_name")
    var firstName: String? = firstName

    @ColumnInfo(name = "last_name")
    var lastName: String? = lastName
}
