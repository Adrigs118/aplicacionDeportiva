package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.utils.Utils
import com.prueba.aplicaciondeportiva.viewModel.nutrition.NutritionViewModel
import kotlinx.android.synthetic.main.fragment_calories.*
import kotlinx.android.synthetic.main.fragment_nutrition.*

class CaloriesFragment : Fragment(){

    private lateinit var viewModel: NutritionViewModel
    private var calories : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(NutritionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_calories, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val act : MainActivity = activity as MainActivity
        act.setActionBarTitle("Calculadora de calorías")

        imageView_add_calories.setOnClickListener{
            val dialog = CaloriesDialogFragment.newInstance("", "")
            dialog.show(childFragmentManager, "Nueva caloria")
        }

        textView_calories_final.text = Utils.getStringByIdName(Utils.getApplicationContext(),"calories_final") + ": 0"
    }

    class CaloriesDialogFragment : DialogFragment(){

        companion object {

            const val TAG = "SimpleDialog"

            private const val KEY_TITLE = "KEY_TITLE"
            private const val KEY_SUBTITLE = "KEY_SUBTITLE"

            fun newInstance(title: String, subTitle: String): CaloriesDialogFragment {
                val args = Bundle()
                args.putString(KEY_TITLE, title)
                args.putString(KEY_SUBTITLE, subTitle)
                val fragment = CaloriesDialogFragment()
                fragment.arguments = args
                return fragment
            }

        }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            //viewModel = ViewModelProviders.of(this).get(NutritionViewModel::class.java)
            val root = inflater.inflate(R.layout.prefab_calories_dialog, container, false)
            return root
        }

        override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
        }

    }
}