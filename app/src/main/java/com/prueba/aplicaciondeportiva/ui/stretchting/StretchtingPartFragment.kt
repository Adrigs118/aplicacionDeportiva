package com.prueba.aplicaciondeportiva.ui.stretchting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.prueba.aplicaciondeportiva.R
import kotlinx.android.synthetic.main.fragment_stretchting.card_chest
import kotlinx.android.synthetic.main.fragment_stretchting_part.*

class StretchtingPartFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_stretchting_part, container, false)
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_chest.setOnClickListener {
            val action = StretchtingPartFragmentDirections.action_stretchtingPartFragment_to_stretchtingDialogFragment()
            findNavController().navigate(action)
        }
    }
}