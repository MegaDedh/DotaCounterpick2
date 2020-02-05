package ru.asshands.softwire.dotacounterpick.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import ru.asshands.softwire.dotacounterpick.R

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }


    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this@MainActivity, R.id.navHostMain).navigateUp()
    }

    // MARK: - Internal logic
    private fun setupNavigation() {
        val navController = Navigation.findNavController(this@MainActivity, R.id.navHostMain)
        bottomNavigation.setupWithNavController(navController)
    }
}


/*
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.navigation_graph).navigateUp()
    }

    private fun setupNavigation (){
        val navController = findNavController(R.id.navigation_graph)
        bottomNavigation.setupWithNavController(navController)
    }
}
*/
