package android.example.cookwithme.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MealResponse(
    @Expose
    @SerializedName("meals")
    var mealsEntity: List<MealsEntity>
)

data class MealsEntity(
    @Expose
    @SerializedName("idMeal")
    val idMeal: String,
    @Expose
    @SerializedName("strMeal")
    val strMeal: String,
    @Expose
    @SerializedName("strCategory")
    val strCategory: String,
    @Expose
    @SerializedName("strArea")
    val strArea: String,
    @Expose
    @SerializedName("strInstructions")
    val strInstructions: String,
    @Expose
    @SerializedName("strMealThumb")
    val strMealThumb: String,
    @Expose
    @SerializedName("strTags")
    val strTags: String,
    @Expose
    @SerializedName("strYoutube")
    val strYoutube: String,
    @Expose
    @SerializedName("strIngredient1")
    val strIngredient1: String,
    @Expose
    @SerializedName("strIngredient2")
    val strIngredient2: String,
    @Expose
    @SerializedName("strIngredient3")
    val strIngredient3: String,
    @Expose
    @SerializedName("strIngredient4")
    val strIngredient4: String,
    @Expose
    @SerializedName("strIngredient5")
    val strIngredient5: String,
    @Expose
    @SerializedName("strIngredient6")
    val strIngredient6: String,
    @Expose
    @SerializedName("strIngredient7")
    val strIngredient7: String,
    @Expose
    @SerializedName("strIngredient8")
    val strIngredient8: String,
    @Expose
    @SerializedName("strIngredient9")
    val strIngredient9: String,
    @Expose
    @SerializedName("strIngredient10")
    val strIngredient10: String,
    @Expose
    @SerializedName("strIngredient11")
    val strIngredient11: String,
    @Expose
    @SerializedName("strIngredient12")
    val strIngredient12: String,
    @Expose
    @SerializedName("strIngredient13")
    val strIngredient13: String,
    @Expose
    @SerializedName("strIngredient14")
    val strIngredient14: String,
    @Expose
    @SerializedName("strIngredient15")
    val strIngredient15: String,
    @Expose
    @SerializedName("strIngredient16")
    val strIngredient16: String,
    @Expose
    @SerializedName("strIngredient17")
    val strIngredient17: String,
    @Expose
    @SerializedName("strIngredient18")
    val strIngredient18: String,
    @Expose
    @SerializedName("strIngredient19")
    val strIngredient19: String,
    @Expose
    @SerializedName("strIngredient20")
    val strIngredient20: String,
    @Expose
    @SerializedName("strMeasure1")
    val strMeasure1: String,
    @Expose
    @SerializedName("strMeasure2")
    val strMeasure2: String,
    @Expose
    @SerializedName("strMeasure3")
    val strMeasure3: String,
    @Expose
    @SerializedName("strMeasure4")
    val strMeasure4: String,
    @Expose
    @SerializedName("strMeasure5")
    val strMeasure5: String,
    @Expose
    @SerializedName("strMeasure6")
    val strMeasure6: String,
    @Expose
    @SerializedName("strMeasure7")
    val strMeasure7: String,
    @Expose
    @SerializedName("strMeasure8")
    val strMeasure8: String,
    @Expose
    @SerializedName("strMeasure9")
    val strMeasure9: String,
    @Expose
    @SerializedName("strMeasure10")
    val strMeasure10: String,
    @Expose
    @SerializedName("strMeasure11")
    val strMeasure11: String,
    @Expose
    @SerializedName("strMeasure12")
    val strMeasure12: String,
    @Expose
    @SerializedName("strMeasure13")
    val strMeasure13: String,
    @Expose
    @SerializedName("strMeasure14")
    val strMeasure14: String,
    @Expose
    @SerializedName("strMeasure15")
    val strMeasure15: String,
    @Expose
    @SerializedName("strMeasure16")
    val strMeasure16: String,
    @Expose
    @SerializedName("strMeasure17")
    val strMeasure17: String,
    @Expose
    @SerializedName("strMeasure18")
    val strMeasure18: String,
    @Expose
    @SerializedName("strMeasure19")
    val strMeasure19: String,
    @Expose
    @SerializedName("strMeasure20")
    val strMeasure20: String,
    @Expose
    @SerializedName("strSource")
    val strSource: String
)