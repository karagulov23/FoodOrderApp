package orlo.karagulov.foodorderapp.ui.dishes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import orlo.karagulov.foodorderapp.R
import orlo.karagulov.foodorderapp.data.models.Dish
import orlo.karagulov.foodorderapp.data.retrofit.RetrofitInstance
import orlo.karagulov.foodorderapp.databinding.FragmentCategoryBinding
import orlo.karagulov.foodorderapp.databinding.FragmentDishesBinding
import orlo.karagulov.foodorderapp.ui.category.CategoryAdapter
import orlo.karagulov.foodorderapp.ui.category.CategoryFragment


class DishesFragment : Fragment() {

    private lateinit var binding: FragmentDishesBinding
    private lateinit var adapter: DishesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dishes, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDishesBinding.bind(view)

        binding.rvDishes.layoutManager = GridLayoutManager(activity,3)


        lifecycleScope.launch {

            val dishes = RetrofitInstance.CategoryApi.getDishes().dishes
            adapter = DishesAdapter(this@DishesFragment, dishes)
            binding.rvDishes.adapter = adapter

            binding.btnAllMenu.setOnClickListener {
                binding.btnAllMenu.isSelected = true
                binding.btnFish.isSelected = false
                binding.btnFig.isSelected = false
                binding.btnSalad.isSelected = false
                adapter.setNewData(dishes)
            }
            binding.btnSalad.setOnClickListener {
                binding.btnSalad.isSelected = true
                binding.btnFish.isSelected = false
                binding.btnFig.isSelected = false
                binding.btnAllMenu.isSelected = false
                val salad = dishes.filter { "Салаты" in it.tegs }
                adapter.setNewData(salad)
            }
            binding.btnFig.setOnClickListener {
                binding.btnFig.isSelected = true
                binding.btnFish.isSelected = false
                binding.btnAllMenu.isSelected = false
                binding.btnSalad.isSelected = false
                val fig = dishes.filter { "С рисом" in it.tegs }
                adapter.setNewData(fig)
            }
            binding.btnFish.setOnClickListener {
                binding.btnFish.isSelected = true
                binding.btnAllMenu.isSelected = false
                binding.btnFig.isSelected = false
                binding.btnSalad.isSelected = false
                val fish = dishes.filter { "С рыбой" in it.tegs }
                adapter.setNewData(fish)
            }

        }

    }

}