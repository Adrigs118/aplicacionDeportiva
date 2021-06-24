package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prueba.aplicaciondeportiva.R
import android.util.DisplayMetrics
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.findNavController
import com.prueba.aplicaciondeportiva.Diet
import com.prueba.aplicaciondeportiva.Utils
import kotlinx.android.synthetic.main.fragment_diet.*
import kotlinx.android.synthetic.main.fragment_diets.*

class DietFragment : Fragment() {

    private lateinit  var  diet: Diet

    fun getDiet() :Diet {return diet}
    fun setDiet(diet : Diet) { this.diet = diet}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_diet, container, false)

        if(Utils.getDietContext() == null) diet = Diet()
        else diet = Utils.getDietContext()!!
        //this.diet = Utils.stringToDiet(arguments?.getStringArray("DIETA")!!.reversedArray())

        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val graph = findNavController().graph
        graph.label = diet.getName()

        val adapter = SectionsPagerAdapter(childFragmentManager)
        adapter.addFragment(DietDescriptionFragment(diet.getMonday()), getString(R.string.monday))
        adapter.addFragment(DietDescriptionFragment(diet.getTuesday()), getString(R.string.tuesday))
        adapter.addFragment(DietDescriptionFragment(diet.getWednesday()), getString(R.string.wednesday))
        adapter.addFragment(DietDescriptionFragment(diet.getThursday()), getString(R.string.thursday))
        adapter.addFragment(DietDescriptionFragment(diet.getFriday()), getString(R.string.friday))
        adapter.addFragment(DietDescriptionFragment(diet.getSaturday()), getString(R.string.saturday))
        adapter.addFragment(DietDescriptionFragment(diet.getSunday()), getString(R.string.sunday))
        dietViewPager.adapter = adapter
        dietTabs.setupWithViewPager(dietViewPager)
    }

    inner class SectionsPagerAdapter(fm:FragmentManager) : FragmentPagerAdapter(fm){

        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }
}