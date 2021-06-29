package com.prueba.aplicaciondeportiva.viewModel.nutrition

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prueba.aplicaciondeportiva.R
import com.prueba.aplicaciondeportiva.database.Entity.DietWithDay
import com.prueba.aplicaciondeportiva.database.GymDatabase
import com.prueba.aplicaciondeportiva.database.Repository.DietRepository
import com.prueba.aplicaciondeportiva.ui.nutrition.DietDescriptionFragment
import com.prueba.aplicaciondeportiva.utils.Utils
import kotlinx.coroutines.launch

import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import android.content.Context


class DietViewModel :ViewModel(){

    fun getStringByIdName(context: Context, idName: String): String {
        val res = context.getResources()
        return res.getString(res.getIdentifier(idName, "string", context.getPackageName()))
    }

    fun getAdapter(fragmentManager: FragmentManager, diet : DietWithDay) : SectionsPagerAdapter{

        var adapter = SectionsPagerAdapter(fragmentManager)
        adapter.addFragment(DietDescriptionFragment(diet.days[0]), getStringByIdName(Utils.getApplicationContext(), "monday"))
        adapter.addFragment(DietDescriptionFragment(diet.days[1]), getStringByIdName(Utils.getApplicationContext(), "tuesday"))
        adapter.addFragment(DietDescriptionFragment(diet.days[2]), getStringByIdName(Utils.getApplicationContext(), "wednesday"))
        adapter.addFragment(DietDescriptionFragment(diet.days[3]), getStringByIdName(Utils.getApplicationContext(), "thursday"))
        adapter.addFragment(DietDescriptionFragment(diet.days[4]), getStringByIdName(Utils.getApplicationContext(), "friday"))
        adapter.addFragment(DietDescriptionFragment(diet.days[5]), getStringByIdName(Utils.getApplicationContext(), "saturday"))
        adapter.addFragment(DietDescriptionFragment(diet.days[6]), getStringByIdName(Utils.getApplicationContext(), "sunday"))
        return adapter
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm){

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