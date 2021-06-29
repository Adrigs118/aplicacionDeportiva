package com.prueba.aplicaciondeportiva.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prueba.aplicaciondeportiva.R
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.prueba.aplicaciondeportiva.MainActivity
import com.prueba.aplicaciondeportiva.database.Entity.DietEntity
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.android.synthetic.main.fragment_diet.*

class DietFragment : Fragment() {

    private lateinit  var  diet: DietWithDay

    fun getDiet() :DietWithDay {return diet}
    fun setDiet(diet : DietWithDay) { this.diet = diet}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(com.prueba.aplicaciondeportiva.R.layout.fragment_diet, container, false)

        if(Utils.getDietContext() == null) diet = DietWithDay()
        else diet = Utils.getDietContext()!!

        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val act : MainActivity= activity as MainActivity
        act.setActionBarTitle(diet.diet.name)

        val adapter = SectionsPagerAdapter(childFragmentManager)

        adapter.addFragment(DietDescriptionFragment(diet.days[0]), getString(R.string.monday))
        adapter.addFragment(DietDescriptionFragment(diet.days[1]), getString(R.string.tuesday))
        adapter.addFragment(DietDescriptionFragment(diet.days[2]), getString(R.string.wednesday))
        adapter.addFragment(DietDescriptionFragment(diet.days[3]), getString(R.string.thursday))
        adapter.addFragment(DietDescriptionFragment(diet.days[4]), getString(R.string.friday))
        adapter.addFragment(DietDescriptionFragment(diet.days[5]), getString(R.string.saturday))
        adapter.addFragment(DietDescriptionFragment(diet.days[6]), getString(R.string.sunday))
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