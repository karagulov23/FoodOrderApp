package orlo.karagulov.foodorderapp.ui.dishes


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import orlo.karagulov.foodorderapp.data.models.Dish
import orlo.karagulov.foodorderapp.databinding.ItemDishBinding

class DishesAdapter(private val context: DishesFragment, private var dishes: List<Dish>) : RecyclerView.Adapter<DishesAdapter.DishesViewHolder>() {

    inner class DishesViewHolder(val binding: ItemDishBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishesViewHolder {
        return DishesViewHolder(ItemDishBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dishes.size
    }

    override fun onBindViewHolder(holder: DishesViewHolder, position: Int) {

            holder.binding.apply {
                tvDish.text = dishes[position].name
                val url = dishes[position].image_url

                Glide.with(context)
                    .load(url)
                    .fitCenter()
                    .into(ivDish)

            cardViewDish.setOnClickListener {
                holder.itemView.findNavController().navigate(DishesFragmentDirections.actionDishesFragmentToDishDetailFragment(dishes[position]))
            }
        }
    }

    fun setNewData(newData: List<Dish>) {
        dishes = newData
        notifyDataSetChanged()
    }

}
