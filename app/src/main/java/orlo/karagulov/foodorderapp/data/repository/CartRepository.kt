package orlo.karagulov.foodorderapp.data.repository

import androidx.lifecycle.LiveData
import orlo.karagulov.foodorderapp.data.database.CartDao
import orlo.karagulov.foodorderapp.data.models.CartItem

class CartRepository(val cartDao: CartDao) {

    suspend fun insert(cartItem: CartItem) = cartDao.insert(cartItem)

    suspend fun update(cartItem: CartItem) = cartDao.update(cartItem)

    suspend fun delete(cartItem: CartItem) = cartDao.delete(cartItem)

    fun getAllCartItem() : LiveData<List<CartItem>> = cartDao.getAllCartItem()

}