package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.utils.DialogAux
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.android.synthetic.main.fragment_diet_edit.*

class DietEditFragment : Fragment(){

    private lateinit  var  diet: DietWithDay
    private var nuevo = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_diet_edit, container, false)

        if (arguments!!.getString("TIPO") == "EDIT")
            nuevo = false

        if(!nuevo){
            if (Utils.getDietContext() == null) diet = DietWithDay()
            else diet = Utils.getDietContext()!!
        }

        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(nuevo){
            imageView_diet_delete.visibility = View.GONE
            imageView_diet_edit.visibility = View.GONE
        }
        else {
            imageView_diet_new.visibility = View.GONE
            //initEditText()
        }

        imageView_diet_delete.setOnClickListener {
            Utils.setDietContext(null)
        }

        imageView_diet_new.setOnClickListener {
            if(editTextName.text.isNullOrEmpty()){
                val dialog = DialogAux(DialogAux.TypeDialog.WARNING, getString(R.string.warning_diet_name), false)
                dialog.show(childFragmentManager, "caution_diet_name_dialog")
            }
            else {
                Utils.setDietContext(this.diet)
            }
        }

        imageView_diet_edit.setOnClickListener {
            if(editTextName.text.isNullOrEmpty()){
                val dialog = DialogAux(DialogAux.TypeDialog.WARNING, getString(R.string.warning_diet_name), false)
                dialog.show(childFragmentManager, "caution_diet_name_dialog")
            }
            else {
                Utils.setDietContext(this.diet)
            }
        }

        //region visibility
        editText_dinner.visibility = View.GONE
        editText_lunch.visibility = View.GONE
        editText_snack.visibility = View.GONE
        editText_breakfast.visibility = View.GONE
        editText_meal.visibility = View.GONE

        editText_dinner2.visibility = View.GONE
        editText_lunch2.visibility = View.GONE
        editText_snack2.visibility = View.GONE
        editText_breakfast2.visibility = View.GONE
        editText_meal2.visibility = View.GONE

        editText_dinner3.visibility = View.GONE
        editText_lunch3.visibility = View.GONE
        editText_snack3.visibility = View.GONE
        editText_breakfast3.visibility = View.GONE
        editText_meal3.visibility = View.GONE

        editText_dinner4.visibility = View.GONE
        editText_lunch4.visibility = View.GONE
        editText_snack4.visibility = View.GONE
        editText_breakfast4.visibility = View.GONE
        editText_meal4.visibility = View.GONE

        editText_dinner5.visibility = View.GONE
        editText_lunch5.visibility = View.GONE
        editText_snack5.visibility = View.GONE
        editText_breakfast5.visibility = View.GONE
        editText_meal5.visibility = View.GONE

        editText_dinner6.visibility = View.GONE
        editText_lunch6.visibility = View.GONE
        editText_snack6.visibility = View.GONE
        editText_breakfast6.visibility = View.GONE
        editText_meal6.visibility = View.GONE

        editText_dinner7.visibility = View.GONE
        editText_lunch7.visibility = View.GONE
        editText_snack7.visibility = View.GONE
        editText_breakfast7.visibility = View.GONE
        editText_meal7.visibility = View.GONE
        //endregion

        //region buttons visibility
        button_monday.setOnClickListener {
            if(editText_dinner.visibility == View.GONE){
                editText_dinner.visibility = View.VISIBLE
                editText_lunch.visibility = View.VISIBLE
                editText_snack.visibility = View.VISIBLE
                editText_breakfast.visibility = View.VISIBLE
                editText_meal.visibility = View.VISIBLE
            }
            else{
                editText_dinner.visibility = View.GONE
                editText_lunch.visibility = View.GONE
                editText_snack.visibility = View.GONE
                editText_breakfast.visibility = View.GONE
                editText_meal.visibility = View.GONE
            }
        }

        button_monday.setOnClickListener {
            if(editText_dinner.visibility == View.GONE){
                editText_dinner.visibility = View.VISIBLE
                editText_lunch.visibility = View.VISIBLE
                editText_snack.visibility = View.VISIBLE
                editText_breakfast.visibility = View.VISIBLE
                editText_meal.visibility = View.VISIBLE
            }
            else{
                editText_dinner.visibility = View.GONE
                editText_lunch.visibility = View.GONE
                editText_snack.visibility = View.GONE
                editText_breakfast.visibility = View.GONE
                editText_meal.visibility = View.GONE
            }
        }

        button_tuesday.setOnClickListener {
            if(editText_dinner2.visibility == View.GONE){
                editText_dinner2.visibility = View.VISIBLE
                editText_lunch2.visibility = View.VISIBLE
                editText_snack2.visibility = View.VISIBLE
                editText_breakfast2.visibility = View.VISIBLE
                editText_meal2.visibility = View.VISIBLE
            }
            else{
                editText_dinner2.visibility = View.GONE
                editText_lunch2.visibility = View.GONE
                editText_snack2.visibility = View.GONE
                editText_breakfast2.visibility = View.GONE
                editText_meal2.visibility = View.GONE
            }
        }

        button_wednesday.setOnClickListener {
            if(editText_dinner3.visibility == View.GONE){
                editText_dinner3.visibility = View.VISIBLE
                editText_lunch3.visibility = View.VISIBLE
                editText_snack3.visibility = View.VISIBLE
                editText_breakfast3.visibility = View.VISIBLE
                editText_meal3.visibility = View.VISIBLE
            }
            else{
                editText_dinner3.visibility = View.GONE
                editText_lunch3.visibility = View.GONE
                editText_snack3.visibility = View.GONE
                editText_breakfast3.visibility = View.GONE
                editText_meal3.visibility = View.GONE
            }
        }

        button_thursday.setOnClickListener {
            if(editText_dinner4.visibility == View.GONE){
                editText_dinner4.visibility = View.VISIBLE
                editText_lunch4.visibility = View.VISIBLE
                editText_snack4.visibility = View.VISIBLE
                editText_breakfast4.visibility = View.VISIBLE
                editText_meal4.visibility = View.VISIBLE
            }
            else{
                editText_dinner4.visibility = View.GONE
                editText_lunch4.visibility = View.GONE
                editText_snack4.visibility = View.GONE
                editText_breakfast4.visibility = View.GONE
                editText_meal4.visibility = View.GONE
            }
        }

        button_friday.setOnClickListener {
            if(editText_dinner5.visibility == View.GONE){
                editText_dinner5.visibility = View.VISIBLE
                editText_lunch5.visibility = View.VISIBLE
                editText_snack5.visibility = View.VISIBLE
                editText_breakfast5.visibility = View.VISIBLE
                editText_meal5.visibility = View.VISIBLE
            }
            else{
                editText_dinner5.visibility = View.GONE
                editText_lunch5.visibility = View.GONE
                editText_snack5.visibility = View.GONE
                editText_breakfast5.visibility = View.GONE
                editText_meal5.visibility = View.GONE
            }
        }

        button_saturday.setOnClickListener {
            if(editText_dinner6.visibility == View.GONE){
                editText_dinner6.visibility = View.VISIBLE
                editText_lunch6.visibility = View.VISIBLE
                editText_snack6.visibility = View.VISIBLE
                editText_breakfast6.visibility = View.VISIBLE
                editText_meal6.visibility = View.VISIBLE
            }
            else{
                editText_dinner6.visibility = View.GONE
                editText_lunch6.visibility = View.GONE
                editText_snack6.visibility = View.GONE
                editText_breakfast6.visibility = View.GONE
                editText_meal6.visibility = View.GONE
            }
        }

        button_sunday.setOnClickListener {
            if(editText_dinner7.visibility == View.GONE){
                editText_dinner7.visibility = View.VISIBLE
                editText_lunch7.visibility = View.VISIBLE
                editText_snack7.visibility = View.VISIBLE
                editText_breakfast7.visibility = View.VISIBLE
                editText_meal7.visibility = View.VISIBLE
            }
            else{
                editText_dinner7.visibility = View.GONE
                editText_lunch7.visibility = View.GONE
                editText_snack7.visibility = View.GONE
                editText_breakfast7.visibility = View.GONE
                editText_meal7.visibility = View.GONE
            }
        }

        //endregion
    }

    /*
    private fun initEditText(){
        editText_dinner.setText(diet.getMonday().getDinner())
        editText_lunch.setText(diet.getMonday().getLunch())
        editText_snack.setText(diet.getMonday().getSnack())
        editText_breakfast.setText(diet.getMonday().getBreakfast())
        editText_meal.setText(diet.getMonday().getMeal())

        editText_dinner2.setText(diet.getTuesday().getDinner())
        editText_lunch2.setText(diet.getTuesday().getLunch())
        editText_snack2.setText(diet.getTuesday().getSnack())
        editText_breakfast2.setText(diet.getTuesday().getBreakfast())
        editText_meal2.setText(diet.getTuesday().getMeal())

        editText_dinner3.setText(diet.getWednesday().getDinner())
        editText_lunch3.setText(diet.getWednesday().getLunch())
        editText_snack3.setText(diet.getWednesday().getSnack())
        editText_breakfast3.setText(diet.getWednesday().getBreakfast())
        editText_meal3.setText(diet.getWednesday().getMeal())

        editText_dinner4.setText(diet.getThursday().getDinner())
        editText_lunch4.setText(diet.getThursday().getLunch())
        editText_snack4.setText(diet.getThursday().getSnack())
        editText_breakfast4.setText(diet.getThursday().getBreakfast())
        editText_meal4.setText(diet.getThursday().getMeal())

        editText_dinner5.setText(diet.getFriday().getDinner())
        editText_lunch5.setText(diet.getFriday().getLunch())
        editText_snack5.setText(diet.getFriday().getSnack())
        editText_breakfast5.setText(diet.getFriday().getBreakfast())
        editText_meal5.setText(diet.getFriday().getMeal())

        editText_dinner6.setText(diet.getSaturday().getDinner())
        editText_lunch6.setText(diet.getSaturday().getLunch())
        editText_snack6.setText(diet.getSaturday().getSnack())
        editText_breakfast6.setText(diet.getSaturday().getBreakfast())
        editText_meal6.setText(diet.getSaturday().getMeal())

        editText_dinner7.setText(diet.getSunday().getDinner())
        editText_lunch7.setText(diet.getSunday().getLunch())
        editText_snack7.setText(diet.getSunday().getSnack())
        editText_breakfast7.setText(diet.getSunday().getBreakfast())
        editText_meal7.setText(diet.getSunday().getMeal())
        */
}