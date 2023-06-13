package orlo.karagulov.foodorderapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.widget.SearchView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import orlo.karagulov.foodorderapp.databinding.ActivityMainBinding
import java.text.DateFormat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        setSupportActionBar(binding.customToolbar)

        val navController = findNavController(R.id.fragment_container)

        binding.bottomNavigationView.setupWithNavController(navController)

        val config = AppBarConfiguration(navController.graph)


        binding.customToolbar.setupWithNavController(navController, config)


        binding.tvDate.text = DateFormat.getDateInstance().format(Calendar.getInstance().time)


    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment_container)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}