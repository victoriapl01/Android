package android.example.cookwithme.entities

import android.example.cookwithme.entities.converter.CategoryListConverter
import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Category")
data class Category(
    @PrimaryKey(autoGenerate = true)
    var id: Int,

    @ColumnInfo(name = "categoryItems")
    @Expose
    @SerializedName("categories")
    @TypeConverters(CategoryListConverter::class)
    var categorieitems: List<CategoryItems>? = null
)

