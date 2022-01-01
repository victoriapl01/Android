package android.example.cookwithme.database


import android.content.Context
import android.example.cookwithme.dao.RecipeDao
import android.example.cookwithme.entities.Recipe
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Recipe::class],version = 1, exportSchema = false)
abstract class RecipeDatabase: RoomDatabase() {
    companion object{
        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase != null){
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
