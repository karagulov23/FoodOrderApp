package orlo.karagulov.foodorderapp.ui.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import orlo.karagulov.foodorderapp.data.database.CartDatabase
import orlo.karagulov.foodorderapp.data.models.CartItem
import orlo.karagulov.foodorderapp.data.repository.CartRepository

class CartViewModel(application: Application) : AndroidViewModel(application) {

    private val cartDao = CartDatabase.getDatabase(application).cartDao()

    private val repository : CartRepository = CartRepository(cartDao)
    val getAllCartItem: LiveData<List<CartItem>> = repository.getAllCartItem()

    fun insert(cartItem: CartItem){
        viewModelScope.launch {
            try {
                repository.insert(cartItem)
            } catch (e: Exception) {

            }
        }
    }

    fun update(cartItem: CartItem){
        viewModelScope.launch {
            repository.update(cartItem)
        }
    }

    fun delete(cartItem: CartItem){
        viewModelScope.launch {
            repository.delete(cartItem)
        }
    }

    fun getAllCartItem(){
        viewModelScope.launch {
            repository.getAllCartItem()
        }
    }

}