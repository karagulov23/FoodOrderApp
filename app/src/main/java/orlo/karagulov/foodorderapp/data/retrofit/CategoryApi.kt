package orlo.karagulov.foodorderapp.data.retrofit

import orlo.karagulov.foodorderapp.data.models.Categories
import orlo.karagulov.foodorderapp.data.models.Dishes
import retrofit2.http.GET



interface CategoryApi {

    @GET("/v3/058729bd-1402-4578-88de-265481fd7d54")
    suspend fun getCategories(): Categories

    @GET("v3/c7a508f2-a904-498a-8539-09d96785446e")
    suspend fun getDishes(): Dishes

}