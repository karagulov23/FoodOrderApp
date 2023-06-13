package orlo.karagulov.foodorderapp.ui.category


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import orlo.karagulov.foodorderapp.data.models.Сategory
import orlo.karagulov.foodorderapp.databinding.ItemCategoryBinding

class CategoryAdapter( private val context: CategoryFragment, private var categories: List<Сategory>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {


    inner class CategoryViewHolder(val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
            holder.binding.apply {
                tvName.text = categories[position].name
                val url = categories[position].image_url
                Glide.with(context)
                    .load(url)
                    .fitCenter()
                    .into(ivCategory)

                cardViewCategory.setOnClickListener {
                    holder.itemView.findNavController().navigate(CategoryFragmentDirections.actionCategoryFragmentToDishesFragment(tvName.text.toString()))
                }

        }
    }



}
