package orlo.karagulov.foodorderapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class CartItem (
@PrimaryKey
    val id: Int,
val description: String,
val image_url: String,
val name: String,
val price: Int,
val tegs: String,
val weight: Int,
val quantity: Int
)
