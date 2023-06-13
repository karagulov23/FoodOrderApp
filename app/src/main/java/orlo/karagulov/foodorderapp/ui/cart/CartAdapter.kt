package orlo.karagulov.foodorderapp.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import orlo.karagulov.foodorderapp.data.models.CartItem
import orlo.karagulov.foodorderapp.databinding.ItemCartBinding


class CartAdapter(private val context: CartFragment) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    private var dataList: List<CartItem> = emptyList()

    inner class CartViewHolder(val binding: ItemCartBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.binding.apply {
            tvCartName.text = dataList[position].name
            tvCartPrice.text = dataList[position].price.toString() + "₽"
            tvCartWeight.text = dataList[position].weight.toString() + "гр"
            tvCartQuantity.text = dataList[position].quantity.toString()
            val url = dataList[position].image_url
            Glide.with(context)
                .load(url)
                .fitCenter()
                .into(ivCart)

            holder.binding.ivPlus.setOnClickListener {
                val currentCount = holder.binding.tvCartQuantity.text.toString().toInt()
                val newCount = currentCount + 1
                holder.binding.tvCartQuantity.text = newCount.toString()
            }
            holder.binding.ivMinus.setOnClickListener {
                val currentCount = holder.binding.tvCartQuantity.text.toString().toInt()
                val newCount = currentCount - 1
                holder.binding.tvCartQuantity.text = newCount.toString()
            }

        }
    }

    fun setData(cartItems: List<CartItem>){
        dataList = cartItems
        notifyDataSetChanged()
    }

    interface OnCounterChangeListener {
        fun onCounterChanged(position: Int, newCount: Int)
    }

}