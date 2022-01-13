package android.example.cookwithme

import android.content.Intent
import android.example.cookwithme.entities.MealResponse
import android.example.cookwithme.interfaces.GetDataService
import android.example.cookwithme.retofitclient.RetrofitClientInstance
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_rv_main_category.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : BaseActivity() {

    var youtubeLink = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val id = intent.getStringExtra("id")

        getSpecificItem(id!!)

        imgToolbarBtnBack.setOnClickListener {
            finish()
        }

        btnYoutube.setOnClickListener{
            val uri: Uri = Uri.parse(youtubeLink)

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

    }

    private fun getSpecificItem(id:String){
        val service = RetrofitClientInstance.retrofitInstance!!.create(GetDataService::class.java)
        val call = service.getSpecificItem(id)
        call.enqueue(object : Callback<MealResponse>{
            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Toast.makeText(this@DetailActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<MealResponse>, response: Response<MealResponse>) {

                Glide.with(this@DetailActivity).load(response.body()!!.mealsEntity[0].strMealThumb).into(imgItem)


                tvCategory.text = response.body()!!.mealsEntity[0].strMeal

                val ingredient = "${response.body()!!.mealsEntity[0].strIngredient1}      ${response.body()!!.mealsEntity[0].strMeasure1}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient2}      ${response.body()!!.mealsEntity[0].strMeasure2}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient3}      ${response.body()!!.mealsEntity[0].strMeasure3}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient4}      ${response.body()!!.mealsEntity[0].strMeasure4}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient5}      ${response.body()!!.mealsEntity[0].strMeasure5}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient6}      ${response.body()!!.mealsEntity[0].strMeasure6}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient7}      ${response.body()!!.mealsEntity[0].strMeasure7}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient8}      ${response.body()!!.mealsEntity[0].strMeasure8}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient9}      ${response.body()!!.mealsEntity[0].strMeasure9}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient10}      ${response.body()!!.mealsEntity[0].strMeasure10}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient11}      ${response.body()!!.mealsEntity[0].strMeasure11}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient12}      ${response.body()!!.mealsEntity[0].strMeasure12}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient13}      ${response.body()!!.mealsEntity[0].strMeasure13}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient14}      ${response.body()!!.mealsEntity[0].strMeasure14}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient15}      ${response.body()!!.mealsEntity[0].strMeasure15}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient16}      ${response.body()!!.mealsEntity[0].strMeasure16}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient17}      ${response.body()!!.mealsEntity[0].strMeasure17}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient18}      ${response.body()!!.mealsEntity[0].strMeasure18}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient19}      ${response.body()!!.mealsEntity[0].strMeasure19}\n" +
                        "${response.body()!!.mealsEntity[0].strIngredient20}      ${response.body()!!.mealsEntity[0].strMeasure20}\n"

                tvIngredients.text = ingredient
                tvInstructions.text = response.body()!!.mealsEntity[0].strInstructions

                if (response.body()!!.mealsEntity[0].strSource != null){
                    youtubeLink = response.body()!!.mealsEntity[0].strSource
                }
                else{
                    btnYoutube.visibility = View.GONE
                }
            }

        })
    }
}