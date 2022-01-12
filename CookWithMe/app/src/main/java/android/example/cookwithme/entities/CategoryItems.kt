package android.example.cookwithme.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "CategoryItems")
data class CategoryItems (
    @PrimaryKey(autoGenerate = true)
    var id:Int,

    @ColumnInfo(name = "idCategory")
    @Expose
    @SerializedName("idCategory")
    val idCategory: String,

    @ColumnInfo(name = "strCategory")
    @Expose
    @SerializedName("strCategory")
    val strCategory: String,

    @ColumnInfo(name = "strCategoryThumb")
    @Expose
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String,

    @ColumnInfo(name = "strCategoryDescription")
    @Expose
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String
)
