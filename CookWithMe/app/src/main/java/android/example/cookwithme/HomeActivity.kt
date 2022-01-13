package android.example.cookwithme

import android.content.Intent
import android.example.cookwithme.adapter.MainCategoryAdapter
import android.example.cookwithme.adapter.SubCategoryAdapter
import android.example.cookwithme.database.RecipeDatabase
import android.example.cookwithme.entities.CategoryItems
import android.example.cookwithme.entities.MealsItems
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch

class HomeActivity : BaseActivity() {

    //Initialize arraylist
    private var arrMainCategory = ArrayList<CategoryItems>()
    private var arrSubCategory = ArrayList<MealsItems>()

    //Initialize adapter
    private var mainCategoryAdapter = MainCategoryAdapter()
    private var subCategoryAdapter = SubCategoryAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        getDataFromDb()

        mainCategoryAdapter.setClickListener(onClicked)
        subCategoryAdapter.setClickListener(onClickedSubItem)




        //temporary data
        //arrMainCategory.add(Recipe(1, "Beef"))
        //arrMainCategory.add(Recipe(2, "Chicken"))
        //arrMainCategory.add(Recipe(3, "Dessert"))
        //arrMainCategory.add(Recipe(4, "Lamb"))

        //mainCategoryAdapter.setData(arrMainCategory)

        //arrSubCategory.add(Recipe(1, "Beef and mustard pie"))
        //arrSubCategory.add(Recipe(2, "Chicken and mushroom hotpot"))
        //arrSubCategory.add(Recipe(3, "Banana pancakes"))
        //arrSubCategory.add(Recipe(4, "kapsalon"))

        //subCategoryAdapter.setData(arrSubCategory)

        //rv_sub_category.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        //rv_sub_category.adapter = subCategoryAdapter

    }

    private val onClicked = object : MainCategoryAdapter.OnItemClickListener{
        override fun onClicked(categoryName: String) {
            getMealDataFromDb(categoryName)
        }
    }
    private val onClickedSubItem = object : SubCategoryAdapter.OnItemClickListener{
        override fun onClicked(id: String) {
            val intent = Intent(this@HomeActivity,DetailActivity::class.java)
            intent.putExtra("id",id)
            startActivity(intent)
        }
    }
    private fun getDataFromDb(){
        launch {
            this.let {
                val cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<CategoryItems>
                arrMainCategory.reverse()

                getMealDataFromDb(arrMainCategory[0].strCategory)
                mainCategoryAdapter.setData(arrMainCategory)
                rv_main_category.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL, false)
                rv_main_category.adapter = mainCategoryAdapter
            }


        }
    }

    private fun getMealDataFromDb(categoryName:String){
        tvCategory.text = "${categoryName}Category"
        launch {
            this.let {
                val cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getSpecificMealList(categoryName)
                arrSubCategory = cat as ArrayList<MealsItems>
                subCategoryAdapter.setData(arrSubCategory)
                rv_sub_category.layoutManager = LinearLayoutManager(this@HomeActivity,LinearLayoutManager.HORIZONTAL, false)
                rv_sub_category.adapter = subCategoryAdapter
            }


        }
    }
}