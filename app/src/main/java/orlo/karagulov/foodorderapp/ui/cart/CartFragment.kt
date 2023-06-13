package orlo.karagulov.foodorderapp.ui.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import orlo.karagulov.foodorderapp.R
import orlo.karagulov.foodorderapp.databinding.FragmentCartBinding
import orlo.karagulov.foodorderapp.ui.viewmodel.CartViewModel

class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var adapter: CartAdapter
    private val cartViewModel: CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCartBinding.bind(view)
        adapter = CartAdapter(this@CartFragment)
        binding.rvCart.layoutManager = LinearLayoutManager(activity)

        cartViewModel.getAllCartItem.observe(viewLifecycleOwner){
            adapter.setData(it)
        }

        binding.rvCart.adapter = adapter

    }

}