package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prueba.aplicaciondeportiva.R
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.database.Entity.DietEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.utils.Utils
import com.prueba.aplicaciondeportiva.viewModel.NotificationsViewModel
import com.prueba.aplicaciondeportiva.viewModel.nutrition.DietViewModel
import kotlinx.android.synthetic.main.fragment_diet.*

class DietFragment : Fragment() {

    private lateinit  var  diet: DietWithDay
    private lateinit var viewModel: DietViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_diet, container, false)
        viewModel = ViewModelProviders.of(this).get(DietViewModel::class.java)
        if(Utils.getDietContext() == null) diet = DietWithDay()
        else diet = Utils.getDietContext()!!

        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val act : MainActivity= activity as MainActivity
        act.setActionBarTitle(diet.diet.name)

        dietViewPager.adapter = viewModel.getAdapter(childFragmentManager, diet)
        dietTabs.setupWithViewPager(dietViewPager)
    }
}