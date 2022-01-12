package android.example.cookwithme.entities.converter

import android.example.cookwithme.entities.Category
import android.example.cookwithme.entities.CategoryItems
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<CategoryItems>):String?{
        if (category == null){
            return (null)
        }
        else{
            val gson = Gson()
            val type = object : TypeToken<CategoryItems>(){

            }.type
            return gson.toJson(category,type)
        }
    }
    @TypeConverter
    fun toCategoryList( categoryString: String):List<CategoryItems>? {
        if (categoryString == null) {
            return (null)
        } else {
            val gson = Gson()
            val type = object : TypeToken<CategoryItems>() {

            }.type
            return gson.fromJson(categoryString, type)
        }
    }
}