package com.prueba.aplicaciondeportiva.ui.nutrition

import android.opengl.Visibility
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prueba.aplicaciondeportiva.Diet
import com.prueba.aplicaciondeportiva.R
import kotlinx.android.synthetic.main.fragment_diet_description.*

class DietDescriptionFragment (val dayDiet: Diet.DayDiet): Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_diet_description, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!dayDiet.getBreakfast().isNullOrEmpty()){
            textViewBreakfastTitle.text = getString(R.string.breakfast)
            textViewBreakfast.text = dayDiet.getBreakfast()
        }
        else{
            textViewBreakfastTitle.visibility = View.GONE
            textViewBreakfast.visibility = View.GONE
        }

        if (!dayDiet.getLunch().isNullOrEmpty()){
            textViewLunchTitle.text = getString(R.string.lunch)
            textViewLunch.text = dayDiet.getLunch()
        }
        else{
            textViewLunchTitle.visibility = View.GONE
            textViewLunch.visibility = View.GONE
        }

        if (!dayDiet.getMeal().isNullOrEmpty()){
            textViewMealTitle.text = getString(R.string.meal)
            textViewMeal.text = dayDiet.getMeal()
        }
        else{
            textViewMealTitle.visibility = View.GONE
            textViewMeal.visibility = View.GONE
        }

        if (!dayDiet.getSnack().isNullOrEmpty()){
            textViewSnackTitle.text = getString(R.string.snack)
            textViewSnack.text = dayDiet.getSnack()
        }
        else{
            textViewSnackTitle.visibility = View.GONE
            textViewSnack.visibility = View.GONE
        }

        if (!dayDiet.getDinner().isNullOrEmpty()){
            textViewDinnerTitle.text = getString(R.string.dinner)
            textViewDinner.text = dayDiet.getDinner()
        }
        else{
            textViewDinnerTitle.visibility = View.GONE
            textViewDinner.visibility = View.GONE
        }
    }
}