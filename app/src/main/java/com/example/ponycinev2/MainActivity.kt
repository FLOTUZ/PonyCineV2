package com.example.ponycinev2

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.ponycinev2.databinding.ActivityMainBinding
import com.example.ponycinev2.models.DataBase
import com.example.ponycinev2.models.Exibicion
import com.example.ponycinev2.models.Pelicula
import com.example.ponycinev2.ui.GlobalViewModel
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val viewModel: GlobalViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.cartelera, R.id.alimentos, R.id.miPerfil
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val bdString = resources.getString(R.string.init_database)
        val bd = Gson().fromJson(bdString, DataBase::class.java) as DataBase

        val horasDeExibicion = ArrayList<Exibicion>()
        horasDeExibicion.add(Exibicion("Jun 06 2021", "05:00 pm"))
        horasDeExibicion.add(Exibicion("Jun 06 2021", "07:00 pm"))
        horasDeExibicion.add(Exibicion("Jun 07 2021", "09:00 pm"))

        bd.peliculas.add(Pelicula(1, "Army Of Dead", R.drawable.armydead, horasDeExibicion))
        bd.peliculas.add(Pelicula(2, "Blackwidow", R.drawable.blackwidow, horasDeExibicion))
        bd.peliculas.add(Pelicula(3, "Mortal Kombat", R.drawable.mk, horasDeExibicion))
        bd.peliculas.add(Pelicula(4, "Spiderman No Way Home", R.drawable.spiderman, horasDeExibicion))
        bd.peliculas.add(Pelicula(5, "The Suicide Squad", R.drawable.suicidesquad2, horasDeExibicion))

        viewModel.setBD(bd)
    }
}