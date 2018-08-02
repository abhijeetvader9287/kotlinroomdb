package demo.kotlinroomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import demo.kotlinroomdb.database.daos.BillDao
import demo.kotlinroomdb.database.daos.CustomerDao
import demo.kotlinroomdb.database.daos.ProviderDao
import demo.kotlinroomdb.database.entities.Bill
import demo.kotlinroomdb.database.entities.Customer
import demo.kotlinroomdb.database.entities.Provider

/**
 * Created by axier on 7/2/18.
 */

@Database(entities = [(Customer::class), (Provider::class), (Bill::class)], version = 5, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    abstract fun providerDao(): ProviderDao

    abstract fun billDao(): BillDao

    companion object {

        /**
         * The only instance
         */
        private var sInstance: AppDatabase? = null

        /**
         * Gets the singleton instance of SampleDatabase.
         *
         * @param context The context.
         * @return The singleton instance of SampleDatabase.
         */
        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                sInstance = Room
                        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "example")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return sInstance!!
        }
    }

}
