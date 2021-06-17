package com.prueba.aplicaciondeportiva

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() , View.OnClickListener {

    private lateinit var nutritionButton: Button
    private lateinit var stretchtingButton: Button
    private lateinit var trainingButton: Button
    private lateinit var weightButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        init()

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_settings, R.id.navigation_notifications
            )
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    private fun init() {

        this.nutritionButton = findViewById(R.id.nutritionButton)
        this.weightButton = findViewById(R.id.weightButton)
        this.stretchtingButton = findViewById(R.id.stretchingButton)
        this.trainingButton = findViewById(R.id.trainingPlansButton)

        nutritionButton.setOnClickListener(this)
        //weightButton.setOnClickListener(this)
        //stretchtingButton.setOnClickListener(this)
        //trainingButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val nutritionIntent = Intent(this, NutritionActivity::class.java)
        startActivity(nutritionIntent)
        finish()
    }


        /*
        val weightIntent = Intent(this, WeightActivity::class.java)
        val stretchtingIntent = Intent(this, StretchtingActivity::class.java)
        val trainingIntent = Intent(this, TrainingPlansActivity::class.java)

    }

*/
}
