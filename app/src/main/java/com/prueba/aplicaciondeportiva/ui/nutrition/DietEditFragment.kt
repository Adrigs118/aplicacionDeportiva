package com.prueba.aplicaciondeportiva.ui.nutrition

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.DietDayEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.utils.DialogAux
import com.prueba.aplicaciondeportiva.utils.Utils
import com.prueba.aplicaciondeportiva.viewModel.nutrition.DietEditViewModel
import kotlinx.android.synthetic.main.fragment_diet_edit.*

class DietEditFragment : Fragment(){

    private lateinit  var  diet: DietWithDay
    private lateinit var viewModel: DietEditViewModel
    private var nuevo = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_diet_edit, container, false)
        viewModel = ViewModelProviders.of(this).get(DietEditViewModel::class.java)
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
            editTextName.isEnabled = false
            initEditText()
        }

        val act : MainActivity = activity as MainActivity
        act.setActionBarTitle(diet.diet.name)

        imageView_diet_delete.setOnClickListener {
            val dialog = AlertDialog.Builder(this.context)
            dialog.setTitle(getString(R.string.information))
            dialog.setIcon(R.mipmap.dialog_information)
            dialog.setMessage(R.string.warning_diet_name)
            dialog.setPositiveButton(getString(R.string.dialog_yes),
                DialogInterface.OnClickListener { dialog, id ->
                    if(!viewModel.delete(createDietWithDay())){
                        val dialog = DialogAux(DialogAux.TypeDialog.ERROR, getString(R.string.warning_diet_name), false)
                        dialog.show(childFragmentManager, "ERROR_diet_name_dialog")
                    }
                    else fragmentManager!!.popBackStackImmediate()
                })
            dialog.setNegativeButton(getString(R.string.dialog_cancel),
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })
            dialog.show()
        }

        imageView_diet_new.setOnClickListener {
            if(editTextName.text.isNullOrEmpty()){
                val dialog = DialogAux(DialogAux.TypeDialog.WARNING, getString(R.string.warning_diet_name), false)
                dialog.show(childFragmentManager, "caution_diet_name_dialog")
            }
            else {
               if(!viewModel.insert(createDietWithDay())){
                   val dialog = DialogAux(DialogAux.TypeDialog.ERROR, getString(R.string.warning_diet_name), false)
                   dialog.show(childFragmentManager, "ERROR_diet_name_dialog")
               }
                else fragmentManager!!.popBackStackImmediate()
            }
        }

        imageView_diet_edit.setOnClickListener {
            if(editTextName.text.isNullOrEmpty()){
                val dialog = DialogAux(DialogAux.TypeDialog.WARNING, getString(R.string.warning_diet_name), false)
                dialog.show(childFragmentManager, "caution_diet_name_dialog")
            }
            else {
               if(!viewModel.updateDiet(createDietWithDay())){
                   val dialog = DialogAux(DialogAux.TypeDialog.ERROR, getString(R.string.warning_diet_name), false)
                   dialog.show(childFragmentManager, "ERROR_diet_name_dialog")
               }
               else fragmentManager!!.popBackStackImmediate()
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

    private fun initEditText() {
        editTextName.setText(diet.diet.name)
        editTextDescription.setText(diet.diet.description)
        editText_dinner.setText(diet.days[0].dinner)
        editText_lunch.setText(diet.days[0].lunch)
        editText_snack.setText(diet.days[0].snack)
        editText_breakfast.setText(diet.days[0].breakfast)
        editText_meal.setText(diet.days[0].meal)

        editText_dinner2.setText(diet.days[1].dinner)
        editText_lunch2.setText(diet.days[1].lunch)
        editText_snack2.setText(diet.days[1].snack)
        editText_breakfast2.setText(diet.days[1].breakfast)
        editText_meal2.setText(diet.days[1].meal)

        editText_dinner3.setText(diet.days[2].dinner)
        editText_lunch3.setText(diet.days[2].lunch)
        editText_snack3.setText(diet.days[2].snack)
        editText_breakfast3.setText(diet.days[2].breakfast)
        editText_meal3.setText(diet.days[2].meal)

        editText_dinner4.setText(diet.days[3].dinner)
        editText_lunch4.setText(diet.days[3].lunch)
        editText_snack4.setText(diet.days[3].snack)
        editText_breakfast4.setText(diet.days[3].breakfast)
        editText_meal4.setText(diet.days[3].meal)

        editText_dinner5.setText(diet.days[4].dinner)
        editText_lunch5.setText(diet.days[4].lunch)
        editText_snack5.setText(diet.days[4].snack)
        editText_breakfast5.setText(diet.days[4].breakfast)
        editText_meal5.setText(diet.days[4].meal)

        editText_dinner6.setText(diet.days[5].dinner)
        editText_lunch6.setText(diet.days[5].lunch)
        editText_snack6.setText(diet.days[5].snack)
        editText_breakfast6.setText(diet.days[5].breakfast)
        editText_meal6.setText(diet.days[5].meal)

        editText_dinner7.setText(diet.days[6].dinner)
        editText_lunch7.setText(diet.days[6].lunch)
        editText_snack7.setText(diet.days[6].snack)
        editText_breakfast7.setText(diet.days[6].breakfast)
        editText_meal7.setText(diet.days[6].meal)
    }

    fun createDietWithDay() : DietWithDay{
        var diet = DietWithDay()
        diet.diet = DietEntity(editTextName.text.toString(), editTextDescription.text.toString(), "")
        diet.days = listOf(
            DietDayEntity("monday", editTextName.text.toString(), editText_breakfast.text.toString(), editText_lunch.text.toString(),
                editText_meal.text.toString(), editText_snack.text.toString(),
                editText_dinner.text.toString()),
            DietDayEntity("tuesday", editTextName.text.toString(), editText_breakfast2.text.toString(), editText_lunch2.text.toString(),
                editText_meal2.text.toString(), editText_snack2.text.toString(),
                editText_dinner2.text.toString()),
            DietDayEntity("wednesday", editTextName.text.toString(), editText_breakfast3.text.toString(), editText_lunch3.text.toString(),
                editText_meal3.text.toString(), editText_snack3.text.toString(),
                editText_dinner3.text.toString()),
            DietDayEntity("thursday", editTextName.text.toString(), editText_breakfast4.text.toString(), editText_lunch4.text.toString(),
                editText_meal4.text.toString(), editText_snack4.text.toString(),
                editText_dinner4.text.toString()),
            DietDayEntity("friday", editTextName.text.toString(), editText_breakfast5.text.toString(), editText_lunch5.text.toString(),
                editText_meal5.text.toString(), editText_snack5.text.toString(),
                editText_dinner5.text.toString()),
            DietDayEntity("saturday", editTextName.text.toString(), editText_breakfast6.text.toString(), editText_lunch6.text.toString(),
                editText_meal6.text.toString(), editText_snack6.text.toString(),
                editText_dinner6.text.toString()),
            DietDayEntity("sunday", editTextName.text.toString(), editText_breakfast7.text.toString(), editText_lunch7.text.toString(),
                editText_meal7.text.toString(), editText_snack7.text.toString(),
                editText_dinner7.text.toString())
        )
        return diet
    }
}