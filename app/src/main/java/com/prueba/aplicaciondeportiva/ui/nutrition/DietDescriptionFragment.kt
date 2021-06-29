package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.DietDayEntity
import com.prueba.aplicaciondeportiva.viewModel.NotificationsViewModel
import com.prueba.aplicaciondeportiva.viewModel.nutrition.DietDescriptionViewModel
import kotlinx.android.synthetic.main.fragment_diet_description.*

class DietDescriptionFragment (val dayDiet: DietDayEntity): Fragment(){

    private lateinit var viewModel: DietDescriptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(DietDescriptionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_diet_description, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setDay(dayDiet)

        textViewBreakfast.text = dayDiet.breakfast
        textViewLunch.text = dayDiet.lunch
        textViewMeal.text = dayDiet.meal
        textViewSnack.text = dayDiet.snack
        textViewDinner.text = dayDiet.dinner
        textViewBreakfastTitle.text = getText(R.string.breakfast)
        textViewLunchTitle.text = getText(R.string.lunch)
        textViewMealTitle.text = getText(R.string.meal)
        textViewSnackTitle.text = getText(R.string.snack)
        textViewDinnerTitle.text = getText(R.string.dinner)

        textViewBreakfast.visibility = if( dayDiet.breakfast.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
        textViewLunch.visibility = if( dayDiet.lunch.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
        textViewMeal.visibility = if( dayDiet.meal.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
        textViewSnack.visibility = if( dayDiet.snack.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
        textViewDinner.visibility = if( dayDiet.dinner.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
        textViewBreakfastTitle.visibility = if( dayDiet.breakfast.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
        textViewLunchTitle.visibility = if( dayDiet.lunch.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
        textViewMealTitle.visibility = if( dayDiet.meal.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
        textViewSnackTitle.visibility = if( dayDiet.snack.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
        textViewDinnerTitle.visibility = if( dayDiet.dinner.isNullOrEmpty()) {View.GONE} else {View.VISIBLE}
    }
}