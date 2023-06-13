package orlo.karagulov.foodorderapp.ui.dishes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import orlo.karagulov.foodorderapp.R
import orlo.karagulov.foodorderapp.data.models.CartItem
import orlo.karagulov.foodorderapp.databinding.DetailDishBinding
import orlo.karagulov.foodorderapp.ui.viewmodel.CartViewModel

class DishDetailFragment : Fragment() {
    private val cartViewModel: CartViewModel by viewModels()

    private lateinit var binding: DetailDishBinding
    private val args by navArgs<DishDetailFragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_dish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DetailDishBinding.bind(view)
        val currentDish = args.currentDish

        binding.apply {
            val url = currentDish.image_url
            Glide.with(this@DishDetailFragment)
                .load(url)
                .fitCenter()
                .into(ivDetailDish)
            tvDishDetailName.text = currentDish.name
            tvDishDetailPrice.text = currentDish.price.toString() + "₽"
            tvDishDetailWeight.text = currentDish.weight.toString() + "гр"
            tvDishDetailDesc.text = currentDish.description

            overlayLayout.setOnTouchListener { _, _ -> true }

            btnAddToCart.setOnClickListener {
                val cartItem = CartItem(
                    currentDish.id,
                    currentDish.description,
                    currentDish.image_url,
                    currentDish.name,
                    currentDish.price,
                    currentDish.weight.toString(),
                    currentDish.weight,
                    1
                )
                cartViewModel.insert(cartItem)

                ivCloseDetail.setOnClickListener {
                    findNavController().popBackStack()
                }

            }

        }
    }
}