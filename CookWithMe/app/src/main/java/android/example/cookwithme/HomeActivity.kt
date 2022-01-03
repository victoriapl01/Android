package android.example.cookwithme

import android.example.cookwithme.adapter.MainCategoryAdapter
import android.example.cookwithme.adapter.SubCategoryAdapter
import android.example.cookwithme.entities.Recipe
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    //Initialize arraylist
    var arrMainCategory = ArrayList<Recipe>()
    var arrSubCategory = ArrayList<Recipe>()

    //Initialize adapter
    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)


        //temporary data
        arrMainCategory.add(Recipe(1, "Beef"))
        arrMainCategory.add(Recipe(2, "Chicken"))
        arrMainCategory.add(Recipe(3, "Dessert"))
        arrMainCategory.add(Recipe(4, "Lamb"))

        mainCategoryAdapter.setData(arrMainCategory)

        arrSubCategory.add(Recipe(1, "Beef and mustard pie"))
        arrSubCategory.add(Recipe(2, "Chicken and mushroom hotpot"))
        arrSubCategory.add(Recipe(3, "Banana pancakes"))
        arrSubCategory.add(Recipe(4, "kapsalon"))

        subCategoryAdapter.setData(arrSubCategory)

        rv_main_category.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        rv_main_category.adapter = mainCategoryAdapter

        rv_sub_category.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rv_sub_category.adapter = subCategoryAdapter

    }
}