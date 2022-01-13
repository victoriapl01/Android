package android.example.cookwithme.interfaces

import android.example.cookwithme.entities.Category
import android.example.cookwithme.entities.Meal
import android.example.cookwithme.entities.MealResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>

    @GET("filter.php")
    fun getMealList(@Query("c") category: String): Call<Meal>

    @GET("lookup.php")
    fun getSpecificItem(@Query("i") id: String): Call<MealResponse>
}