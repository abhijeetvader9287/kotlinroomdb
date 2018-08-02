package demo.kotlinroomdb.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import demo.kotlinroomdb.database.entities.Bill

/**
 * Created by axier on 7/2/18.
 */

@Dao
interface BillDao {

    @get:Query("SELECT * FROM bill")
    val all: List<Bill>

    @Query("SELECT * FROM bill WHERE uid IN (:billIds)")
    fun loadAllByIds(billIds: Array<Int>): List<Bill>

    @Query("SELECT * FROM bill WHERE customer_id = :uid")
    fun findByCustomerId(uid: Int): List<Bill>

    @Insert
    fun insertAll(bills: List<Bill>)

    @Insert
    fun insert(bill: Bill)

    @Delete
    fun delete(bill: Bill)

}
