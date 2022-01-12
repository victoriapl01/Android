package android.example.cookwithme.adapter

import  android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.example.cookwithme.R
import android.example.cookwithme.entities.Meal
import android.example.cookwithme.entities.MealsItems
import android.example.cookwithme.entities.Recipe
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_rv_main_category.view.*


class SubCategoryAdapter:RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var listener: SubCategoryAdapter.OnItemClickListener? = null
    var ctx :Context? = null
    var arrSubCategory = ArrayList<MealsItems>()
    class RecipeViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    fun setData(arrData : List<MealsItems>){
        arrSubCategory = arrData as ArrayList<MealsItems>
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_sub_category,parent, false))
    }

    fun setClickListener(listener1: SubCategoryAdapter.OnItemClickListener){
        listener = listener1
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.tv_dish_name.text = arrSubCategory[position].strMeal
        Glide.with(ctx!!).load(arrSubCategory[position].strMealThumb).into(holder.itemView.img_dish)

        holder.itemView.rootView.setOnClickListener{
            listener!!.onClicked(arrSubCategory[position].id)
        }
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    interface OnItemClickListener{
        fun onClicked(id:Int)
    }
}