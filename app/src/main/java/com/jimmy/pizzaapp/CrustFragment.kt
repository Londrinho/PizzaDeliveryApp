package com.jimmy.pizzaapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.jimmy.pizzaapp.databinding.FragmentCrustBinding


class CrustFragment : Fragment() {

    private lateinit var binding: FragmentCrustBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_crust, container, false)

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener { gotToPizzaScreen() }
    }

    fun gotToPizzaScreen(){
        findNavController().navigate(R.id.action_crustFragment_to_pizzaFragment)
    }


}