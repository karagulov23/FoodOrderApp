package orlo.karagulov.foodorderapp.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import orlo.karagulov.foodorderapp.R
import orlo.karagulov.foodorderapp.data.retrofit.RetrofitInstance
import orlo.karagulov.foodorderapp.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var adapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCategoryBinding.bind(view)

        binding.rvCategory.layoutManager = LinearLayoutManager(activity)

        lifecycleScope.launch {
            val category = RetrofitInstance.CategoryApi.getCategories()
            adapter = CategoryAdapter(this@CategoryFragment, category.сategories)
            binding.rvCategory.adapter = adapter
        }
    }


}