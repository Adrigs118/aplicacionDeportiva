package com.prueba.aplicaciondeportiva.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Dao.BodyDao
import com.prueba.aplicaciondeportiva.database.Dao.ConfigDao
import com.prueba.aplicaciondeportiva.database.Entity.*
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.DietRepository
import kotlinx.coroutines.launch

@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {

    lateinit var  configRepository : ConfigDao
    lateinit var  dietRepository : DietRepository
    lateinit var  bodyRepository : BodyDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        configRepository = GymDatabase.getInstance(applicationContext)!!.configDao()
        dietRepository = DietRepository(GymDatabase.getInstance(applicationContext)!!.dietDao())
        bodyRepository = GymDatabase.getInstance(applicationContext)!!.bodyDao()

        val backgroundImage : ImageView = findViewById(R.id.SplashScreenImage)
        val rotateAnimation = AnimationUtils.loadAnimation(this,
            R.anim.rotation
        )
        backgroundImage.startAnimation(rotateAnimation)

        initBd()

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2500)
    }

    fun initBd(){
        lifecycleScope.launch {
            val aux = configRepository.get()
            if (aux == null){
                configRepository.insert(ConfigEntity(0, true))
                dietRepository.insert(firstDiet())
                dietRepository.insert(secondDiet())
                bodyRepository.insert(firstBody())
            }
        }
    }

    fun firstBody() : BodyEntity {
        val bodyEntity = BodyEntity(0, true, 0, 0.0F, 0, 0.0)
        return bodyEntity
    }

    fun firstDiet() : DietWithDay {
        val diet = DietWithDay()
        diet.diet = DietEntity("Flexitariana", "Dieta con poca carne", "Prueba")
        diet.days = listOf(
            DietDayEntity("monday", "Flexitariana", "Tortitas de arroz con crema choco industrial","", "Arroz blanco", "", "Seitán"),
            DietDayEntity("tuesday", "Flexitariana", "Pan de semillas (hecho con harina blanca)", "", "El buen plato de garbanzos", "", "Soja texturizada"),
            DietDayEntity("wednesday", "Flexitariana", "Copos de avena con leche", "", "Hamburguesa de soja", "", "Garbanzos"),
            DietDayEntity("thursday", "Flexitariana", "Galletas veganas con leche", "", "El buen plato de lentejas", "", "Seitán"),
            DietDayEntity("friday", "Flexitariana", "Tostadas o biscotes", "", "Tofu con vegetales", "", "Huevo"),
            DietDayEntity("saturday", "Flexitariana", "Bizcocho fit", "", "Hamburguesa de seitán", "", "Gambas de soja"),
            DietDayEntity("sunday", "Flexitariana", "Tortitas de arroz", "", "Pescado", "", "Tofu")
        )
        return diet
    }

    fun secondDiet() : DietWithDay {
        val diet = DietWithDay()
        diet.diet = DietEntity("Proteica", "Alta en proteinas", "Prueba")
        diet.days = listOf(
            DietDayEntity("monday", "Proteica", "Vaso de leche con cacao y galletas integrales", "Frutas troceadas con muesli y Mini BabyBel (1 unidad)",
                "Menestra de verduras, Filete de ternera con patatas fritas y manzana", "Bocadillo de atún",
                "Guisantes salteados con jamón, tortilla francesa con tomate aliñado y Mini Babybel, mandarinas"),
            DietDayEntity("tuesday", "Proteica", "Vaso de leche con cacao y tostadas con queso fresco", "Bocadillo de jamón de york",
                "Macarrones a la boloñesa, rodajas de merluza con ensalada y plátano", "Macedonia de frutas con MiniBabybel (2)",
                "Puré de calabacín, Pollo rebozado con alcachofas, yogurt"),
            DietDayEntity("wednesday", "Proteica", "Vaso de leche con cacao y cereales", "Mini bocadillos con Babybel(1)",
                "Arroz a la milanesa, Tortilla de verduras con queso, pera en almibar", "Yogurt y zumo de frutas",
                "Sopa de ave con fideos, sepia a la plancha con ensalada y yogurt"),
            DietDayEntity("thursday", "Proteica", "Vaso de leche con cacao y tostadas con jamón", "Sandwich vegetal",
                "Potaje de lentejas, conejo al horno con zanahoria baby, yogurt", "Brocheta de frutas con queso",
                "Judías con patatas, huevos fritos con ensalada y naranja"),
            DietDayEntity("friday", "Proteica", "Vaso de leche y cereales de desayuno", "MiniBabybel(1) y zomo de frutas",
                "Arroz salteado con verduras, salmón a la plancha con espárragos trigueros, uvas", "Yogurt con cereales con desayuno",
                "Patata gratinada con queso y jamón, muslitos de pollo con tomate aliñado, mandarinas"),
            DietDayEntity("saturday", "Proteica", "Vaso de leche con cacao y tostadas con mermelada", "Yogurt con fresas",
                "Canelones de espinacas, albóndigas a la jardinera, manzana asada", "Sandwich de jamón y queso",
                "Ensaladilla rusa, buñuelos de bacalao con champiñones salteados, yogurt"),
            DietDayEntity("sunday", "Proteica", "Vaso de leche con cacao y tostadas y mermelada", "Zumo de frutas",
                "Paella de pescado y marisco, bacalao con ensalada, piña en almibar", "Bocadillo de atún",
                "Sopa de ave con fideos, brochetas de pollo con pimiento y tomate, yogurt")
        )
        return diet
    }
}
