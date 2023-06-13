package orlo.karagulov.foodorderapp.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dish(
    val description: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val price: Int,
    val tegs: List<String>,
    val weight: Int
) : Parcelable