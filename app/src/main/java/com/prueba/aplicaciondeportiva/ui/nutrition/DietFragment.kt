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
import kotlinx.android.synthetic.main.fragment_diet.*
import kotlinx.android.synthetic.main.fragment_diets.*

class DietFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_diet, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val displayMetrics = context!!.getResources().displayMetrics
        val dpWidth = displayMetrics.widthPixels / displayMetrics.density

        val title: String? = arguments?.getString("NAME")

        val adapter = SectionsPagerAdapter(childFragmentManager)
        adapter.addFragment(DietDescriptionFragment(), "Monday")
        adapter.addFragment(DietDescriptionFragment(), "Tuesday")
        adapter.addFragment(DietDescriptionFragment(), "Wednesday")
        adapter.addFragment(DietDescriptionFragment(), "Thursday")
        adapter.addFragment(DietDescriptionFragment(), "Friday")
        adapter.addFragment(DietDescriptionFragment(), "Saturday")
        adapter.addFragment(DietDescriptionFragment(), "Sunday")
        dietViewPager.adapter = adapter
        dietTabs.setupWithViewPager(dietViewPager)

        //tituloDietatextView.setText(title)
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

            /*when (position) {
                0 -> return "MONDAY"
                1 -> return "TUESDAY"
                2 -> return "WEDNESDAY"
                3 -> return "THURSDAY"
                4 -> return "FRIDAY"
                5 -> return "SATURDAY"
                6 -> return "SUNDAY"
                else -> return ""
            }*/
    }
}