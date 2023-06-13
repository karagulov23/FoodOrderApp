package orlo.karagulov.foodorderapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import orlo.karagulov.foodorderapp.data.models.CartItem
@Dao
interface CartDao {

    @Insert
    suspend fun insert(cartItem: CartItem)

    @Update
    suspend fun update(cartItem: CartItem)

    @Delete
    suspend fun delete(cartItem: CartItem)

    @Query("SELECT * FROM cart_table")
    fun getAllCartItem(): LiveData<List<CartItem>>

}