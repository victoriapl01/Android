package android.example.cookwithme.database


import android.content.Context
import android.example.cookwithme.dao.RecipeDao
import android.example.cookwithme.entities.*
import android.example.cookwithme.entities.converter.CategoryListConverter
import android.example.cookwithme.entities.converter.MealListConverter
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Recipe::class, CategoryItems::class, Category::class, MealsItems::class],version = 1, exportSchema = false)
@TypeConverters(CategoryListConverter::class, MealListConverter::class)
abstract class RecipeDatabase: RoomDatabase() {
    companion object{
        private var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase == null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }
    abstract fun recipeDao():RecipeDao
}
