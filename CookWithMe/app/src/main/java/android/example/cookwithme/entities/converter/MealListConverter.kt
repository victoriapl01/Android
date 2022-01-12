package android.example.cookwithme.entities.converter

import android.example.cookwithme.entities.Category
import android.example.cookwithme.entities.CategoryItems
import android.example.cookwithme.entities.MealsItems
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MealListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<MealsItems>):String?{
        if (category == null){
            return (null)
        }
        else{
            val gson = Gson()
            val type = object : TypeToken<MealsItems>(){

            }.type
            return gson.toJson(category,type)
        }
    }
    @TypeConverter
    fun toCategoryList( categoryString: String):List<MealsItems>? {
        if (categoryString == null) {
            return (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<MealsItems>() {

            }.type
            return gson.fromJson(categoryString, type)
        }
    }
}