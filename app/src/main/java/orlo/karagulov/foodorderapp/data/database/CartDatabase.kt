package orlo.karagulov.foodorderapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import orlo.karagulov.foodorderapp.data.models.CartItem

@Database(entities = arrayOf(CartItem::class), version = 1, exportSchema = false)
abstract class CartDatabase: RoomDatabase() {
    abstract fun cartDao(): CartDao
    companion object {
        @Volatile
        private var INSTANCE: CartDatabase? = null

        fun getDatabase(context: Context): CartDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        CartDatabase::class.java,
                        "cart_database").fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}